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
public class ListNode {

    int id;
    Object element;
    ListNode next;

    /**
     * constructor sin parametros
     */
    ListNode() {
    }

    /**
     * Constructor con parametros de la clase
     *
     * @param id id
     * @param element element
     */
    ListNode(int id, Object element) {
        this.id = id;
        this.element = element;
    }

    /**
     * Constructor con parametros de la clase
     *
     * @param id id
     * @param element element
     * @param next next
     */
    ListNode(int id, Object element, ListNode next) {
        this.id = id;
        this.element = element;
        this.next = next;
    }

}
