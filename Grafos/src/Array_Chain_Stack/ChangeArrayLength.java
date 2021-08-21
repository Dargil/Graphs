/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array_Chain_Stack;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 1.013.686.675
 * @author JUAN JOSE PARADA PEÑALOZA 1.094.282.262
 * @since 13/09/2017
 *
 */
import java.lang.reflect.Array;

public class ChangeArrayLength {

    /**
     * Este metodo permite aumentar el tamaño de la lista
     *
     * @param a Object[]: 
     * @param n int:
     * @param newLength int:
     * @return Object[]:
     */
    public static Object[] changeLength1D(Object[] a, int n, int newLength) {
        // make sure new length is adequate
        if (n > newLength) {
            throw new IllegalArgumentException("new length is too small");
        }

        // allocate a new array of desired length and same type
        Object[] newArray = (Object[]) Array.newInstance(a.getClass().getComponentType(), newLength);

        // copy from old space to new space
        // System.arraycopy (Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(a, 0, newArray, 0, n);

        return newArray;
    }

    // full array a is to be copied into new array
    /**
     *
     * @param a Object[]:
     * @param newLength int:
     * @return Object[]:
     */
    public static Object[] changeLength1D(Object[] a, int newLength) {
        return changeLength1D(a, a.length, newLength);
    }
}
