/*
 * Esta clase me permite dar solucion a los primero 9 numeros de la serie de padovan ya que despues del 9 el dato es muy grande 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PadovanPrime;

import Array_Chain_Stack.ArrayLinearList;
import java.util.Scanner;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 1.013.686.675
 * @author JUAN JOSE PARADA PEÑALOZA 1.094.282.262
 * @since 13/09/2017
 *
 */
public class PadovanPrime {

    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("¿Digite en n-esimo número primo de la serie de Padovan que desea conocer?");
        int n = leerDatos.nextInt();
        System.out.println("n-esimo número primo: " + primePadovan(n));
    }

    /**
     * Este metodo me permite obtener la serie de los numeros de padovan que son
     * exclusivamente primos
     *
     * @param n int: hace referencia al e-enesimo numero de la serie que quiere
     * ser encontrado
     * @return int: el e-enesimo numero de la serie
     */
    public static int primePadovan(int n) {
        ArrayLinearList padovan = new ArrayLinearList();
        ArrayLinearList primePadovan = new ArrayLinearList();
        padovan.add(0, 1);
        padovan.add(1, 1);
        padovan.add(2, 1);
        int j = 0;
        for (int i = 3; j < n; i++) {
            int nSerie = (int) padovan.get(i - 2) + (int) padovan.get(i - 3);
            padovan.add(i, nSerie);
            if (isPrime(nSerie) == true) {
                if (j == 0) {
                    primePadovan.add(j, nSerie);
                    j++;
                } else if ((int) primePadovan.get(j - 1) != nSerie) {
                    primePadovan.add(j, nSerie);
                    j++;
                }
            }
        }
        return (int) primePadovan.get(n - 1);
    }

    /**
     * Este metodo me permite saber si un numero es primo
     *
     * @param n int: numero a evaluar
     * @return true si el numero es primo, false en otro caso
     */
    public static boolean isPrime(int n) {
        ArrayLinearList primos = new ArrayLinearList();
        primos.add(0, 2);
        if (n == 2) {
            return true;
        }
        for (int i = 1; (int) primos.get(i - 1) < n; i++) {
            int k = (int) primos.get(primos.size() - 1) + 1;
            for (int l = 0; l < primos.size(); l++) {
                if (k % (int) primos.get(l) == 0) {
                    l = -1;
                    k++;
                }
            }
            if (k == n) {
                return true;
            }
            primos.add(i, k);
        }
        return false;
    }

    /**
     * Este metodo me permite obtener el n-enesimo numero de la serie de padovan
     * usando la tecnica de programacion dinamica
     *
     * @param a int: limite para calcular la serie de padovan
     */
    public static void padovanSerie(int a) {
        ArrayLinearList padovan = new ArrayLinearList();
        padovan.add(0, 1);
        padovan.add(1, 1);
        padovan.add(2, 1);
        for (int i = 3; i <= a; i++) {
            padovan.add(i, (int) padovan.get(i - 2) + (int) padovan.get(i - 3));
        }
        System.out.println(padovan);
    }

    /**
     * Este metodo me permite obtener el n-ensimo primo con la tecnica de
     * programacion dinamica
     *
     * @param a int: limite para calcular los numeros primos
     */
    public static void primosSerie(int a) {
        ArrayLinearList primos = new ArrayLinearList();
        primos.add(0, 2);
        for (int i = 1; i < a; i++) {
            int k = (int) primos.get(primos.size() - 1) + 1;
            for (int l = 0; l < primos.size(); l++) {
                if (k % (int) primos.get(l) == 0) {
                    l = -1;
                    k++;
                }
            }
            primos.add(i, k);
        }
        for (int i = 0; i < primos.size(); i++) {
            System.out.println(primos.get(i));
        }
    }
}
