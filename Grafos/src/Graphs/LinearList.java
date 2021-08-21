/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 
 * @author JUAN JOSE PARADA PEÑALOZA 
 * @since 13/09/2017
 *
 */
public interface LinearList {

    /**
     * Este metodo nos permite saber si una lista esta vacia Return
     *
     * @return true if the list is empty. false otherwise
     */
    public boolean isEmpty();

    /**
     * Este metodo nos permite saber el tamaño de la lista
     *
     * @return the number of elements in the list
     */
    public int size();

    /**
     * Obtiene un elemento de la lista dado un indice
     *
     * @param index int: que hace referencia a la ubicacion donde se buscara el
     * objeto
     * @return Object the index-th element of the list
     */
    public Object get(int index);

    /**
     * muestra el indice de la consulta de un elemento en la lista
     *
     * @param theElement Object : elemento que se va a buscar en la lista
     * @return the position of the first occurrence of x in the list, return -1
     * if x is not in the list
     */
    public int indexOf(Object theElement);

    /**
     * Remueve un elemento de la lista
     *
     * @param index int: ubicacion del elemento en la lista que sera eliminado
     * @return the index-th element, elements with higher index have their index
     * reduced by 1
     */
    public Object remove(int index);

    /**
     * Insert x as the index-th element, elements with index mayor o igua index have their
     * index increased by 1
     *
     * @param index int: posicion donde va a ser agregado el nuevo elemento
     * @param theElement Object: Elemento que se ubicara sobre la lista
     */
    public void add(int index, Object theElement);

    /**
     * Este metodo permite imprimir la lista
     *
     * @return String: Output the list elements from left to right
     */
    public String toString();

}
