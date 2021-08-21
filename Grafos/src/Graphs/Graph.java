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
public interface Graph {

    /**
     * permite insertar los vertices
     *
     * @param n int: numero de vertices a insertar
     */
    public void insertVertex(int n);

    /**
     * Permite eliminar un vertice
     *
     * @param v int: numero del vertice a eliminar
     */
    public void deleteVertex(int v);

    /**
     * permite insertar un Edge
     *
     * @param i int: numero del Edge de inicio
     * @param j int: numero del Edge del final
     */
    public void insertEdge(int i, int j);

    /**
     * permite eliminar un Edge
     *
     * @param i int: numero del Edge de inicio
     * @param j int: numero del Edge del final
     */
    public void deleteEdge(int i, int j);

    /**
     * permite saber si la estructura es vacia
     *
     * @return true si es vacia false en otro caso
     */
    public boolean isEmpty();

    /**
     * permite saber si existe una conexion entre dos edges
     *
     * @param i int: numero del Edge de inicio
     * @param j int: numero del Edge del final
     * @return true si existe un edge entre los dos nodos, false en otro caso
     */
    public boolean existEdge(int i, int j);

    /**
     *
     * @param i nodo a consultar
     * @return int: cantidad de nodos de entrada
     */
    public int degreeIn(int i);

    /**
     *
     * @param i nodo a consultar
     * @return int: cantidad de nodos de salidad
     */
    public int degreeOut(int i);

    /**
     *
     * @param i nodo a consultar
     * @return int: cantidad de nodos de salida mas los nodos de entrada
     */
    public int incidence(int i);

    /**
     * permite saber el numero de vertices que existe en la estructura
     *
     * @return int: es el tamaño del numVertex en la estructura, 0 si esta esta
     * vacia
     */
    public int size();

}
