/*
 * Esta clase me permite resolver el problema de Freckles Uva 10034
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrecklesProblem;

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
public class Freckles {

    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        int a = leerDatos.nextInt();

        for (int k = 0; k < a; k++) {
            leerDatos.nextLine();
            int n = leerDatos.nextInt();
            Chain coordenadas = new Chain();
            for (int i = 0; i < n; i++) {
                double x = Double.parseDouble(leerDatos.next());
                double y = Double.parseDouble(leerDatos.next());
                coordenadas.add(i, new NodoCoordenadas(x, y));
            }
            GraphAdyList grafo = new GraphAdyList(n, false);
            grafo.insertVertex(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    NodoCoordenadas nodo1 = (NodoCoordenadas) coordenadas.get(i);
                    NodoCoordenadas nodo2 = (NodoCoordenadas) coordenadas.get(j);
                    double x1 = nodo1.getX();
                    double x2 = nodo2.getX();
                    double y1 = nodo1.getY();
                    double y2 = nodo2.getY();
                    double peso = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                    grafo.insertEdgeWeightDouble(i, j, peso);
                }
            }
            double valor = grafo.kruskal();
            System.out.println((double) Math.round(valor * 100d) / 100d);
            System.out.println("");
        }
    }
}
