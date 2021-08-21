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
public class ChainNode {

    Object element;
    ChainNode next;

    /**
     * Contructor sin parametros
     */
    ChainNode() {
    }

    /**
     * Constructor
     *
     * @param element elemento que ingresa e inicializa el atributo element
     */
    ChainNode(Object element) {
        this.element = element;
    }

    /**
     * Constructor
     *
     * @param element elemento que ingresa e inicializa el atributo element
     * @param next Apuntador del nodo next
     */
    ChainNode(Object element, ChainNode next) {
        this.element = element;
        this.next = next;
    }

}
