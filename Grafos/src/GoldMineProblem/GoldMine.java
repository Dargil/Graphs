
/*
 * Esta clase me permite dar solucion al problema de la mina de oro
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoldMineProblem;

import Array_Chain_Stack.ArrayLinearList;
import java.util.Scanner;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 1.013.686.675
 * @author JUAN JOSE PARADA PEÑALOZA 1.094.282.262
 * @since 13/09/2017
 *
 */
public class GoldMine {

    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("Prueba quemando datos");
        ArrayLinearList matriz = new ArrayLinearList();
        ArrayLinearList matriz1 = new ArrayLinearList();
        ArrayLinearList matriz2 = new ArrayLinearList();
        ArrayLinearList matriz3 = new ArrayLinearList();
        ArrayLinearList matriz4 = new ArrayLinearList();
        matriz1.add(0, 1);
        matriz1.add(1, 3);
        matriz1.add(2, 1);
        matriz1.add(3, 5);
        matriz.add(0, matriz1);

        matriz2.add(0, 2);
        matriz2.add(1, 2);
        matriz2.add(2, 4);
        matriz2.add(3, 1);
        matriz.add(1, matriz2);

        matriz3.add(0, 5);
        matriz3.add(1, 0);
        matriz3.add(2, 2);
        matriz3.add(3, 3);
        matriz.add(2, matriz3);

        matriz4.add(0, 0);
        matriz4.add(1, 6);
        matriz4.add(2, 1);
        matriz4.add(3, 2);
        matriz.add(3, matriz4);
        System.out.println("__matriz ingresada__");
        for (int i = 0; i < matriz.size(); i++) {
            System.out.println(matriz.get(i));
        }
        System.out.println("Resultado: " + goldMine(matriz));
        System.out.println("");
        System.out.println("PRUEBA INGRESANDO DATOS");
        System.out.println("Primera linea: entero T (numero de casos) ");
        System.out.println("Segunda linea: entero n y m indicando el tamaño de la matriz");
        System.out.println("Tercera linea: valores de la matriz en una sola linea separada por espacios");
        System.out.println("Ejemplo: ");
        System.out.println("Input");
        System.out.println("1");
        System.out.println("3 3");
        System.out.println("1 3 3 2 1 4 0 6 4");
        System.out.println("Output");
        System.out.println("12");
        System.out.println("INGRESE LOS DATOS DEACUERDO A LAS ESPECIFICACIONES ANTERIORES");

        int t = leerDatos.nextInt();
        for (int k = 0; k < t; k++) {
            int n = leerDatos.nextInt();
            int m = leerDatos.nextInt();
            ArrayLinearList prueba = new ArrayLinearList();
            for (int i = 0; i < n; i++) {
                ArrayLinearList aux = new ArrayLinearList();
                for (int j = 0; j < m; j++) {
                    aux.add(j, leerDatos.nextInt());
                }
                prueba.add(i, aux);
            }
            System.out.println(goldMine(prueba));
        }
    }

    /**
     * Este metodo me permite Obtener el maximo oro moviendome segun las
     * restriciones del problema
     *
     * @param mine ArrayLinearList que es la mina con su oro
     * @return int: maxima cantidad de oro obtenidad
     */
    public static int goldMine(ArrayLinearList mine) {
        ArrayLinearList mineTable = new ArrayLinearList();
        ArrayLinearList aux = (ArrayLinearList) mine.get(0);
        int columnas = aux.size();
        int filas = mine.size();
        for (int i = 0; i < filas; i++) {
            ArrayLinearList aux1 = new ArrayLinearList();
            for (int j = 0; j < columnas; j++) {
                aux1.add(j, 0);
            }
            mineTable.add(i, aux1);
        }

        for (int i = columnas - 1; i >= 0; i--) {
            for (int j = 0; j < filas; j++) {
                int right = 0;
                int right_up = 0;
                int right_down = 0;
                if (i == columnas - 1) {
                    right = 0;
                } else {
                    ArrayLinearList auxRight = (ArrayLinearList) mineTable.get(j);
                    right = (int) auxRight.get(i + 1);
                }
                if (j == 0 || i == columnas - 1) {
                    right_up = 0;
                } else {
                    ArrayLinearList auxright_up = (ArrayLinearList) mineTable.get(j - 1);
                    right_up = (int) auxright_up.get(i + 1);
                }
                if (j == filas - 1 || i == columnas - 1) {
                    right_down = 0;
                } else {
                    ArrayLinearList auxright_down = (ArrayLinearList) mineTable.get(j + 1);
                    right_down = (int) auxright_down.get(i + 1);
                }
                ArrayLinearList auxiliarTable = (ArrayLinearList) mineTable.get(j);
                ArrayLinearList auxiliarMine = (ArrayLinearList) mine.get(j);
                auxiliarTable.set(i, (int) auxiliarMine.get(i) + mayor(right, right_up, right_down));
            }
        }

        ArrayLinearList auxMayor = (ArrayLinearList) mineTable.get(0);
        int mayor = (int) auxMayor.get(0);
        for (int i = 0; i < filas; i++) {
            ArrayLinearList a = (ArrayLinearList) mineTable.get(i);
            mayor = Math.max(mayor, (int) a.get(0));
        }
        return mayor;
    }

    /**
     * Este metodo me permite obtener el dato mayor entre tres datos de tipo int
     *
     * @param a int: dato 1 a comparar
     * @param b int: dato 2 a comparar
     * @param c int: dato 3 a comparar
     * @return int: el dato mayor de los tres datos ingresados
     */
    public static int mayor(int a, int b, int c) {
        int mayor = a;
        if (mayor <= b) {
            mayor = b;
        }
        if (mayor <= c) {
            mayor = c;
        }
        return mayor;
    }

}
