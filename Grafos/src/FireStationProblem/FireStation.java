/*
 * Esta clase me permite resolver el problema de Fire Station de Uva 10278
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FireStationProblem;

import Array_Chain_Stack.Chain;
import Graphs.GraphAdyList;
import java.util.Scanner;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 1.013.686.675
 * @author JUAN JOSE PARADA PEÑALOZA 1.094.282.262
 * @since 13/09/2017
 *
 */
public class FireStation {

    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        int nCasos = leerDatos.nextInt();
        for (int l = 0; l < nCasos; l++) {
            leerDatos.nextLine();
            int nEstaciones = leerDatos.nextInt();
            int nInterseciones = leerDatos.nextInt();
            Chain estaciones = new Chain();
            GraphAdyList grafo = new GraphAdyList(nInterseciones, false);
            grafo.insertVertex(nInterseciones);

            for (int i = 0; i < nEstaciones; i++) {
                int ubicacionEstacion = leerDatos.nextInt();
                estaciones.add(i, ubicacionEstacion - 1);
            }
            if (nInterseciones == 1) {
                System.out.println(1);
                System.out.println("");
            } else {
                for (int i = 0; i < nInterseciones; i++) {
                    int x = leerDatos.nextInt();
                    int y = leerDatos.nextInt();
                    int peso = leerDatos.nextInt();
                    grafo.insertEdgeWeightInt(x - 1, y - 1, peso);
                }

                Chain matriz = new Chain(); //Todos los caminos
                matriz = grafo.matrizAdyacenciaWeightm();
                grafo.floidWarshal(matriz);

                Chain estacionesMin = new Chain();
                Chain auxiliar = (Chain) matriz.get((int) estaciones.get(0));
                for (int i = 0; i < matriz.size(); i++) {
                    estacionesMin.add(i, auxiliar.get(i));
                }

                for (int i = 1; i < estaciones.size(); i++) {
                    Chain aux = (Chain) matriz.get((int) estaciones.get(i));
                    for (int j = 0; j < estacionesMin.size(); j++) {
                        estacionesMin.set(j, menor((int) estacionesMin.get(j), (int) aux.get(j)));
                    }
                }

                Chain matrizFinal = new Chain();
                for (int i = 0; i < matriz.size(); i++) {
                    Chain aux1 = (Chain) matriz.get(i);
                    Chain aux2 = new Chain();
                    for (int j = 0; j < aux1.size(); j++) {
                        aux2.add(j, menor((int) estacionesMin.get(j), (int) aux1.get(j)));
                    }
                    matrizFinal.add(i, aux2);
                }
                Chain resultado = new Chain();
                for (int i = 0; i < matrizFinal.size(); i++) {
                    Chain auxiliarcito = (Chain) matrizFinal.get(i);
                    int mayor = (int) auxiliarcito.get(0);
                    for (int j = 1; j < auxiliarcito.size(); j++) {
                        if ((int) auxiliarcito.get(j) > mayor) {
                            mayor = (int) auxiliarcito.get(j);
                        }
                    }
                    resultado.add(i, mayor);
                }
                int pos = 1;
                int menor = (int) resultado.get(0);
                for (int i = 1; i < resultado.size(); i++) {
                    if ((int) resultado.get(i) < menor) {
                        menor = (int) resultado.get(i);
                        pos = i + 1;
                    }
                }
                System.out.println(pos);
                System.out.println("");

            }
        }
    }

    /**
     * Este metodo me permite obtener el dato menor de dos int
     *
     * @param a int: primer dato a comparar
     * @param b int: segundo dato a comparar
     * @return int: es el dato menor de los dos datos ingresados
     */
    public static int menor(int a, int b) {
        int menor = a;
        if (menor > b) {
            menor = b;
        }
        return menor;
    }

}
