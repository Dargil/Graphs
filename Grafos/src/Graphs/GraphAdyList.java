/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import Array_Chain_Stack.Chain;

/**
 *
 * @author JEFFERSON DARIO MARIN GIRALDO 
 * @author JUAN JOSE PARADA PEÑALOZA 
 * @since 13/09/2017
 *
 */
public class GraphAdyList implements Graph {

    boolean diGraph;
    int maxVertex;
    int numVertex;
    List listAdy[];
    int raiz[]; // arreglo auxiliar para hacer el metodo de kruskal
    Chain aristas; //Chain que almacena los edges creados para ser utilizado en el metodo de kruskal

    /**
     * Constructor
     *
     * @param d boolean: isdiGrap
     */
    public GraphAdyList(boolean d) {
        maxVertex = numVertex = 0;
        diGraph = d;
    }

    /**
     * Constructor
     *
     * @param n inr: maxVertex
     * @param d boolean; isdiGrap
     */
    public GraphAdyList(int n, boolean d) {
        diGraph = d;
        maxVertex = n;
        numVertex = 0;
        listAdy = new List[n];
        aristas = new Chain();
    }

    public void insertVertex(int n) {
        if (n > maxVertex - numVertex) {
            System.out.println("Error");
        } else {
            for (int i = numVertex; i < numVertex + n; i++) {
                listAdy[i] = new List();
            }
            numVertex += n;
        }
    }

    public void deleteVertex(int v) {

        if (v > listAdy.length) {
            System.out.println("Error");
        } else {
            listAdy[v].firstNode = null;
            for (int i = 0; i < listAdy.length; i++) {
                if (existEdge(i, v)) {
                    deleteEdge(i, v);
                }
            }
        }
    }

    public void insertEdge(int i, int j) {
        if (i >= numVertex && j >= numVertex) {
            System.out.println("Error");
        } else {
            listAdy[i].add(listAdy[i].size, j);
            if (!diGraph) {
                listAdy[j].add(listAdy[j].size, i);
            }
        }

    }

    /**
     * Este metodo permite insertar un edge con un peso entre dos nodos,
     * teniendo el peso con un valor double
     *
     * @param i int: nodo de inicio
     * @param j int: nodo final
     * @param peso int:peso entre los dos nodos
     */
    public void insertEdgeWeightInt(int i, int j, int peso) {
        if (i >= numVertex && j >= numVertex) {
            System.out.println("Error");
        } else {
            listAdy[i].add(listAdy[i].size, new Arco(j, (int) peso));
            if (!diGraph) {
                listAdy[j].add(listAdy[j].size, new Arco(i, (int) peso));
            }
        }
    }

    /**
     * Este metodo permite insertar un edge con un peso entre dos nodos,
     * teniendo el peso con un valor double
     *
     * @param i int: nodo de inicio
     * @param j int: nodo final
     * @param peso double:peso entre los dos nodos
     */
    public void insertEdgeWeightDouble(int i, int j, double peso) {
        if (i >= numVertex && j >= numVertex) {
            System.out.println("Error");
        } else {
            aristas.add(aristas.size(), new Edge(i, j, peso));
            listAdy[i].add(listAdy[i].size, new Arco(j, (double) peso));
            if (!diGraph) {
                listAdy[j].add(listAdy[j].size, new Arco(i, (double) peso));
            }
        }
    }

    public void deleteEdge(int i, int j) {
        if (i >= numVertex && j >= numVertex) {
            System.out.println("Error");
        } else {
            listAdy[i].remove(listAdy[i].indexOf(j));
            if (!diGraph) {
                if (listAdy[j].indexOf(i) != -1) {
                    listAdy[j].remove(listAdy[j].indexOf(i));
                }
            }
        }
    }

    public boolean isEmpty() {

        for (int i = 0; i < listAdy.length; i++) {
            if (listAdy[i] != null) {
                return false;
            }
        }
        return true;

    }

    public boolean existEdge(int i, int j) {
        if (listAdy[i] == null) {
            return false;
        }
        ListNode aux = listAdy[i].firstNode;
        while (aux != null) {
            if (aux.element.equals(j)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public int degreeIn(int v) {
        int dgIn = 0;
        for (int i = 0; i < numVertex; i++) {
            if (i != v) {
                if (listAdy[i].indexOf(v) != -1) {
                    dgIn++;
                }
            }
        }
        return dgIn;
    }

    public int degreeOut(int i) {
        int dgOut = 0;
        ListNode aux = listAdy[i].firstNode;
        while (aux != null) {
            dgOut++;
            aux = aux.next;
        }
        return dgOut;
    }

    public int incidence(int i) {
        if (!diGraph) {
            return degreeIn(i);
        } else {
            return degreeIn(i) + degreeOut(i);
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < numVertex; i++) {
            size += numElementos(listAdy[i]);
        }
        if (!diGraph) {
            size = size / 2;
        }
        return size;
    }

    public int numElementos(List lista) {
        ListNode aux = lista.firstNode;
        int resul = 0;
        while (aux != null) {
            resul += 1;
            aux = aux.next;
        }
        return resul;
    }

    /**
     * Me permite imprimir la estructura
     */
    public void printGraph() {
        System.out.println("Number maximum of vertices: " + maxVertex + "\n");
        System.out.println("the graph has " + numVertex + " vertex: \n");
        for (int i = 0; i < numVertex; i++) {
            System.out.print("Vertex " + i + ": ");
            toString(listAdy[i]);
        }
    }

    /**
     * Permite obtener todos los valores de la lista y almacenarlos en un String
     *
     * @param lista List: posee toda la informacion de la estructura
     */
    public void toString(List lista) {
        ListNode aux;
        aux = lista.firstNode;
        String str = "";
        while (aux != null) {
            str += aux.element + ", ";
            aux = aux.next;
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        System.out.println("[" + str + "]");
    }

    /**
     * Permite inmprimir el grafo con pesos de valores enteros
     */
    public void printGraphWeightInt() {
        System.out.println("Number maximum of vertices: " + maxVertex + "\n");
        System.out.println("the graph has " + numVertex + " vertex: \n");
        for (int i = 0; i < numVertex; i++) {
            System.out.print("Vertex " + i + ": ");
            toStringWeightInt(listAdy[i]);
        }
    }

    /**
     * Permite obtener todos los valores de la lista y almacenarlos en un String
     *
     * @param lista List: posee toda la informacion de la estructura
     */
    public void toStringWeightInt(List lista) {
        ListNode aux;
        aux = lista.firstNode;
        String str = "";
        while (aux != null) {
            Arco a = (Arco) aux.element;
            str += (int) a.destino + "(" + (int) a.peso + ")" + ", ";
            aux = aux.next;
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        System.out.println("[" + str + "]");
    }

    /**
     * Permite inmprimir el grafo con pesos de valores double
     */
    public void printGraphWeightDouble() {
        System.out.println("Number maximum of vertices: " + maxVertex + "\n");
        System.out.println("the graph has " + numVertex + " vertex: \n");
        for (int i = 0; i < numVertex; i++) {
            System.out.print("Vertex " + i + ": ");
            toStringWeightInt(listAdy[i]);
        }
    }

    /**
     * Permite obtener todos los valores de la lista y almacenarlos en un String
     *
     * @param lista List: posee toda la informacion de la estructura
     */
    public void toStringWeightDouble(List lista) {
        ListNode aux;
        aux = lista.firstNode;
        String str = "";
        while (aux != null) {
            Arco a = (Arco) aux.element;
            str += (int) a.destino + "(" + (double) a.peso + ")" + ", ";
            aux = aux.next;
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        System.out.println("[" + str + "]");
    }

    /**
     * Este metodo permite obtener la matriz de adyacencia de un grafo sin pesos
     *
     * @return Chain que hace referencia a la matriz de adyacencia generada con
     * la estructura
     */
    public Chain matrizdeAdyacencia() {
        Chain matriz = new Chain();
        for (int i = 0; i < numVertex; i++) {
            Chain matrizaux = new Chain();
            ListNode aux = listAdy[i].firstNode;
            for (int j = 0; j < numVertex; j++) {
                matrizaux.add(j, 0);
            }
            while (aux != null) {
                if ((int) matrizaux.get((int) aux.element) == 0) {
                    matrizaux.set((int) aux.element, 1);
                    aux = aux.next;
                } else {
                    matrizaux.set((int) aux.element, (int) matrizaux.get((int) aux.element) + 1);
                    aux = aux.next;
                }
            }
            matriz.add(i, matrizaux);
        }
        return matriz;
    }

    /**
     * Este metodo permite obtener la matriz de adyacencia de un grafo con pesos
     *
     * @return Chain que hace referencia a la matriz de adyacencia generada con
     * la estructura
     */
    public Chain matrizAdyacenciaWeightm() {
        Chain matriz = new Chain();
        for (int i = 0; i < numVertex; i++) {
            Chain matrizaux = new Chain();
            ListNode aux = listAdy[i].firstNode;
            for (int j = 0; j < numVertex; j++) {
                if (i == j) {
                    matrizaux.add(j, 0);
                } else {
                    matrizaux.add(j, 99999);
                }
            }
            while (aux != null) {
                Arco dato = (Arco) aux.element;
                if ((int) matrizaux.get((int) dato.destino) == 99999) {
                    matrizaux.set((int) dato.destino, dato.peso);
                    aux = aux.next;
                }
            }
            matriz.add(i, matrizaux);
        }
        return matriz;
    }

    /**
     * Este metodo me permite obtener todos los caminos minimos partiendo de
     * todos los nodos del grafo
     *
     * @param matriz Chain que hace referencia a la matriz de adyacencia
     */
    public void floidWarshal(Chain matriz) {
        Chain pi = new Chain();
        for (int i = 0; i < matriz.size(); i++) {
            Chain aux = (Chain) matriz.get(i);
            Chain aux2 = new Chain();
            for (int j = 0; j < aux.size(); j++) {
                if (i == j || (int) aux.get(j) == 99999) {
                    aux2.add(j, -1);
                } else {
                    aux2.add(j, (i + 1));
                }
            }
            pi.add(i, aux2);
        }
        for (int k = 0; k < numVertex; k++) {
            Chain auxk = (Chain) matriz.get(k);
            Chain auxpik = (Chain) pi.get(k);
            for (int i = 0; i < numVertex; i++) {
                Chain auxi = (Chain) matriz.get(i);
                Chain auxpii = (Chain) pi.get(i);
                for (int j = 0; j < numVertex; j++) {
                    int a = (int) auxi.get(j);
                    auxi.set(j, minimo((int) auxi.get(j), (int) auxi.get(k), (int) auxk.get(j)));
                    matriz.set(i, auxi);
                    if (a != (int) auxi.get(j)) {
                        auxpii.set(j, auxpik.get(j));
                        pi.set(i, auxpii);
                    }

                }
            }
        }
    }

    /**
     * Este metodo me permite hallar el minimo entre dos numeros, a y b+c
     *
     * @param a int: primer numero
     * @param b int: segundo numero
     * @param c int:tercer numero
     * @return int: es el dato minimo entre a y b+c
     */
    public int minimo(int a, int b, int c) {
        int menor = 0;
        int suma = b + c;
        menor = a;
        if (menor >= suma) {
            menor = suma;
        }
        return menor;
    }

    /**
     * Para la implementacion del metodo de kruskal nos guiamos de las
     * siguientes paginas:
     * https://jariasf.wordpress.com/2012/04/19/arbol-de-expansion-minima-algoritmo-de-kruskal/
     * https://jariasf.wordpress.com/2012/04/02/disjoint-set-union-find/
     *
     * @return double que es el peso del arbol de expancion minima
     */
    public double kruskal() {
        iniciarRaiz(maxVertex);
        insertionSort(aristas);
        double pesos = 0;
        for (int i = 0; i < aristas.size(); i++) {
            Edge arista = (Edge) aristas.get(i);
            if (mismaComponente(arista.origen, arista.destino) == false) {
                union(arista.origen, arista.destino);
                pesos += arista.getPeso();
            }
        }
        return pesos;
    }

    /**
     * Este metodo me permite ordenar un Chain
     *
     * @param a Chain matriz que va a ser ordenada
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

    /**
     * permite imprimir los valores almacenados en el arreglo raiz
     */
    public void mostrarpadre() {
        for (int i = 0; i < raiz.length; i++) {
            System.out.println(raiz[i]);
        }
    }

    /**
     * permite inicializa el arreglo raiz
     *
     * @param n int: que hace referencia al numero de nodos presentes en el
     * grafo
     */
    public void iniciarRaiz(int n) {
        raiz = new int[n];
        for (int i = 0; i < n; ++i) {
            raiz[i] = i;
        }
    }

    /**
     * permite saber si dos nodos estan en la misma componente
     *
     * @param x nodo x
     * @param y nodo y
     * @return true si estan en la misma componente, false en otro caso
     */
    public boolean mismaComponente(int x, int y) {
        if (buscarRaiz(x) == buscarRaiz(y)) {
            return true;
        }
        return false;
    }

    /**
     * Permite unir dos nodos en el arreglo de raiz
     *
     * @param x nodo x
     * @param y nodo y
     */
    public void union(int x, int y) {
        int raizX = buscarRaiz(x);
        int raizY = buscarRaiz(y);
        raiz[raizX] = raizY;
    }

    /**
     * Este metodo me permite conocer la raiz de un nodo
     *
     * @param x nodo x
     * @return int: que hace referencia al nodo raiz del nodo ingresado
     */
    public int buscarRaiz(int x) {
        if (x == raiz[x]) {
            return x;
        } else {
            return buscarRaiz(raiz[x]);
        }
    }

    /**
     * Este metodo me permite determinar el camino mas corto dado un vertice
     * origen al resto de los vertices de un grafo
     *
     * @param nodoInicio int que hacer refencial al nodo donde se inicia el
     * algoritmo
     */
    public void dijkstra(int nodoInicio) {
        Double d[] = new Double[numVertex];
        Integer π[] = new Integer[numVertex];
        boolean q[] = new boolean[numVertex];
        for (int i = 0; i < numVertex; i++) {
            d[i] = Double.POSITIVE_INFINITY;
            π[i] = null;
            q[i] = true;
        }
        d[nodoInicio] = 0.0;
        for (int i = 0; i < numVertex; i++) {
            int pos = buscarMenor(d, q);
            ListNode a = listAdy[pos].firstNode;
            while (a != null) {
                Arco pes = (Arco) a.element;
                double peso = (double) pes.peso;
                if (d[pes.destino] > (d[pos] + peso)) {
                    d[pes.destino] = (d[pos] + peso);
                    π[pes.destino] = pos;
                }
                a = a.next;
            }
            if (cntBoolean(q) == q.length) {
                break;
            }
        }
        System.out.println("RESULTADO FINAL");
        System.out.println(" --d--");
        imprimirArray(d);
        System.out.println("---π--");
        imprimirArray(π);
    }

    /**
     * Metodo auxiliar del dijkstra
     *
     * @param b array de datos booleans
     * @return int que hace referencia a la cantidad de tatos false que ay en un
     * array de booleans
     */
    public int cntBoolean(boolean b[]) {
        int cnt = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == false) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Metodo auxiliar del dijkstra
     *
     * @param a [] array de datos Double
     * @param b [] array de datos boolean
     * @return int que hace referencia a la posicion donde se encuentra el dato
     * menor
     */
    public int buscarMenor(Double a[], boolean b[]) {
        int pos = 0;
        double menor = menortrue(a, b);
        for (int i = 0; i < a.length; i++) {
            if (menor >= a[i]) {
                if (b[i] == true) {
                    menor = a[i];
                    pos = i;
                }
            }
        }
        b[pos] = false;
        return pos;
    }

    /**
     * Metodo auxiliar del dijkstra
     *
     * @param a [] array de datos Double
     * @param b [] array de datos booleans
     * @return int que hace referencia a la posicion donde se encuentra el dato
     * menor y no se ha utilizado
     */
    public double menortrue(Double a[], boolean b[]) {
        double menor = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == true) {
                menor = a[i];
                break;
            }
        }
        return menor;
    }

    /**
     * este metodo me permite imprimir un array de Integers
     *
     * @param a Integer: arreglo que sera impreso
     */
    public void imprimirArray(Integer a[]) {
        String valor = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                valor += "*" + ", ";
            } else {
                valor += a[i] + ", ";
            }
        }
        if (valor.length() > 1) {
            valor = valor.substring(0, valor.length() - 2);
        }
        System.out.println("[" + valor + "]");
    }

    /**
     * Permite imprimir un array de Double
     *
     * @param a [] array de datos Double
     */
    public void imprimirArray(Double a[]) {
        String valor = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                valor += "*" + ", ";
            } else {
                valor += a[i] + ", ";
            }
        }
        if (valor.length() > 1) {
            valor = valor.substring(0, valor.length() - 2);
        }
        System.out.println("[" + valor + "]");
    }

    /**
     * perimite imprimir un array de booleans
     *
     * @param a [] array de datos boolean
     */
    public void imprimirArrayBoolean(boolean a[]) {
        String valor = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] == true) {
                valor += "t" + ", ";
            } else {
                valor += "f" + ", ";
            }
        }
        if (valor.length() > 1) {
            valor = valor.substring(0, valor.length() - 2);
        }
        System.out.println("[" + valor + "]");
    }

}
