/*
 * Esta clase me permite resolver el problema BankruptBaker de Uva 2283
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankruptBaker;

import Array_Chain_Stack.Chain;
import java.util.Scanner;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 
 * @author JUAN JOSE PARADA PEÑALOZA 
 * @since 13/09/2017
 *
 */
public class Wolfgang {

    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        int t = leerDatos.nextInt();
        for (int k = 0; k < t; k++) {
            leerDatos.nextLine();
            String title = leerDatos.nextLine();
            int m, n, b;
            m = leerDatos.nextInt();
            n = leerDatos.nextInt();
            b = leerDatos.nextInt();
            HashTable costIngredient = new HashTable(m);
            for (int i = 0; i < m; i++) {
                String ingredient = leerDatos.next();
                int c = leerDatos.nextInt();
                costIngredient.put(ingredient, c);
            }
            Chain receta = new Chain();
            for (int i = 0; i < n; i++) {
                leerDatos.nextLine();
                String nombreReceta = leerDatos.nextLine();
                int cntIngredientes = leerDatos.nextInt();
                int costo = 0;
                for (int j = 0; j < cntIngredientes; j++) {
                    String nombreIngrediente = leerDatos.next();
                    int cantidad = leerDatos.nextInt();
                    costo += (int) costIngredient.get(nombreIngrediente) * cantidad;
                }
                receta.add(i, new Receta(nombreReceta, costo));
            }
            System.out.println(title.toUpperCase());
            insertionSort(receta);
            boolean a = true;
            for (int i = 0; i < receta.size(); i++) {
                Receta p = (Receta) receta.get(i);
                if (p.costo <= b) {
                    System.out.println(p.nombre);
                    a = false;
                }
                if ((i == receta.size() - 1) && a == true) {
                    System.out.println("Too expensive!");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Metodo de ordenamiento el cual permite ordenar una estructura Chain, en
     * este caso de la Clase Receta por su costo, el Chain almacena una lista de
     * objetos de la clase Receta
     *
     * @param a Chain el cual almacena una lista de la clase Object
     */
    public static void insertionSort(Chain a) {
        for (int i = 1; i < a.size(); i++) {
            // insert a[i] into a[0:i-1]
            Comparable t = (Comparable) a.get(i);
            // find proper place for t
            int j;
            for (j = i - 1; j >= 0 && (t.compareTo(a.get(j)) < 0); j--) {
                a.set(j + 1, a.get(j));
            }
            a.set(j + 1, t);
        }
    }
}
