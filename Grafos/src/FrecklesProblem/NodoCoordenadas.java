/*
 * Esta clase esta implementada para ayudar a dar solucion al problema de Freckles, almacenando las coordenadas de cada peca dada
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrecklesProblem;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 1.013.686.675
 * @author JUAN JOSE PARADA PEÑALOZA 1.094.282.262
 * @since 13/09/2017
 *
 */
public class NodoCoordenadas {

    public double x;
    public double y;

    /**
     * Constructor
     *
     * @param x double: coordenada x
     * @param y double: coordenada y
     */
    public NodoCoordenadas(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * permite obtener la coordenada x
     *
     * @return double: coordenada x
     */
    public double getX() {
        return x;
    }

    /**
     * Permite modificar la coordenada x
     *
     * @param x nuevo valor de la coordenada x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * permite obtener el valor de la coordenada y
     *
     * @return double: valor de la coordenada y
     */
    public double getY() {
        return y;
    }

    /**
     * permite modificar la coordenada y
     *
     * @param y nuevo valor de la coordenada y
     */
    public void setY(double y) {
        this.y = y;
    }

}
