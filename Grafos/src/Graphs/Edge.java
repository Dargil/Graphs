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
public class Edge implements Comparable<Edge> {

    public int origen;
    public int destino;
    public double peso;

    /**
     * Constructor de la clase Edge
     *
     * @param origen int: origen
     * @param destino int: destino
     * @param peso double: peso
     */
    public Edge(int origen, int destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * permite obtener el valor del edge de origen
     *
     * @return int: valor del edge de origen
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * permite modificar el valor del edge de origen
     *
     * @param origen int: nuevo valor del edge de origen
     */
    public void setOrigen(int origen) {
        this.origen = origen;
    }

    /**
     * permite obtener el valor del edge destino
     *
     * @return int: valor del edge destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * permite modificar el valor del edge destino
     *
     * @param destino int: nuevo valor del edge destino
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * permite obtener el valor del edge peso
     *
     * @return valor del edge peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * permite modificar el valor del edge peso
     *
     * @param peso int: nuevo valor del edge peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Metodo implementado de la interface comparable que me permite en caso de
     * ordenar los objetos de la clase hacerlo por peso
     *
     * @param t Objeto de la clase Edge el cual va a se comparado
     * @return -1 si el peso del objeto ingresado es mayor que el peso del otro
     * objeto comparado 1 si el peso del objeto ingresado es menor que el costo
     * del otro objeto comparado, o en otro caso
     *
     */
    @Override
    public int compareTo(Edge t) {
        if (peso < t.peso) {
            return -1;
        }
        if (peso > t.peso) {
            return 1;
        }
        return 0;
    }

}
