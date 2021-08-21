/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 1.013.686.675
 * @author JUAN JOSE PARADA PEÑALOZA 1.094.282.262
 * @since 13/09/2017
 *
 */
public class Arco {

    public int destino;
    public Object peso;

    /**
     * Contructor de la clase Arco
     *
     * @param destino int destino
     * @param peso Object peso
     */
    public Arco(int destino, Object peso) {
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * permite obtener el valor del destino
     *
     * @return int: valor del destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * permite modificar el valor del destino
     *
     * @param destino int: nuevo valor del destino
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * permite obtener el valor del peso
     *
     * @return int: valor del peso
     */
    public Object getPeso() {
        return peso;
    }

    /**
     * permite modificar el valor del peso
     *
     * @param peso int: nuevo valor del peso
     */
    public void setPeso(Object peso) {
        this.peso = peso;
    }

}
