/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankruptBaker;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 
 * @author JUAN JOSE PARADA PEÑALOZA 
 * @since 13/09/2017
 *
 */
public class Receta implements Comparable<Receta> {

    String nombre;
    int costo;

    /**
     * Constructor de la clase Receta
     *
     * @param nombre String: nombre de la receta
     * @param costo int: costo de la receta
     */
    public Receta(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    /**
     * Este metodo permite obtener el nombre de la receta
     *
     * @return String: nombre de la receta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo permite modificar el nombre de la receta
     *
     * @param nombre String que hace referencia al nuevo nombre que tendra la
     * receta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo me permite obtener el costo de la receta
     *
     * @return int que es el costo de la receta
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Este metodo permite modificar el costo
     *
     * @param costo int que hace referenca al costo de la receta
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Metodo implementado de la interface comparable que me permite en caso de
     * ordenar los objetos de la clase hacerlo por costos
     *
     * @param t Objeto de la clase Receta el cual va a se comparado
     * @return -1 si el costo del objeto ingresado es mayor que el costo del
     * otro objeto comparado 1 si el costo del objeto ingresado es menor que el
     * costo del otro objeto comparado, o en otro caso
     *
     */
    @Override
    public int compareTo(Receta t) {
        if (costo < t.costo) {
            return -1;
        }
        if (costo > t.costo) {
            return 1;
        }
        return 0;
    }

}
