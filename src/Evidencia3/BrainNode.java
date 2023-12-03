package Evidencia3;

import java.io.Serializable;

/**
 * La serialización es el proceso de convertir el estado de un objeto en una secuencia de bytes,
 * que se puede guardar en un archivo o enviar a través de la red.
 * que es básicamente lo que se usaría para que se guarden los datos en IntelliJ
 *
 **/

public class BrainNode implements Serializable {
    private final String PREG_INICIAL = "¿Tiene cuernos?";
    private final String RESP_INICIAL[] = {"Toro", "Gato"};
    Node raiz;
    Node actual;
    Node anterior;

    /**
     * Consturctor del BrainNode
     */
    public BrainNode(){
        raiz = null;
        actual = null;
        anterior = null;
    }

    /**
     * Establece el primer nodo, dándole los valores que se declararon como iniciales
     */
    public void iniciarNodo(){
        actual = raiz = new Node(PREG_INICIAL);
        this.raiz.izquierdo = new Node(RESP_INICIAL[1]);
        this.raiz.derecho = new Node(RESP_INICIAL[0]);
    }

    /**
     * Devuelve el Nodo actual
     * @return el Nodo actual
     */
    public Node getActual(){
        return actual;
    }

    /**
     * Devuelve el valor de un Nodo
     * @param node Nodo objetivo
     * @return el valor del Nodo Objetivo
     */
    public String getData(Node node){
        return node.data;
    }

    /**
     * Actualiza/avanza el nodo
     * @param n índice para saber a qué rama del árbol se fue
     */
    public void actualizarActual(int n){
        if(n == 1){
            anterior = actual;
            actual = this.actual.derecho;
        } else if (n == 0) {
            anterior = actual;
            actual = this.actual.izquierdo;
        }else{
            System.out.println("Hubo un problema y no se pudo actualizar el Nodo Actual");
            System.exit(n);
        }
    }

    /**
     * Crea un Nodo
     * @param pregunta la pregunta
     * @param respuesta la respuesta
     * @param n el índice para saber por qué lado se va
     */
    public void crearNodo(String pregunta, String respuesta, int n){
        Node node = new Node(pregunta);
        Node temp;
        temp = actual;
        actual = node;
        actual.izquierdo = temp;
        actual.derecho = new Node(respuesta);

        if (n == 1){
            anterior.derecho = actual;
        } else if (n == 0) {
            anterior.izquierdo = actual;
        }else{
            System.out.println("Hubo un problema y no se pudo añadir un Nuevo Nodo.");
            System.exit(n);
        }
        reset();
        System.out.println("Se añadió el Nuevo Nodo");
    }

    /**
     * Reinicia el nodo actual, volviéndolo raíz otra vez
     */
    public void reset(){
        actual = raiz;
    }

    /**
     * Para saber si tiene hojas o no
     * @return Devuelve true si sí, false si no
     */
    public boolean tieneHoja(){
        return (actual.izquierdo == null && actual.derecho == null);
    }

    /**
     * Devuelve el valor del hijo izquierdo
     * @return valor del hijo izquierdo
     */
    public String getActualIzq(){
        return this.actual.izquierdo.data;
    }

    /**
     * Devuelve el valor del hijo derecho
     * @return valor del hijo derecho
     */
    public String getActualDer(){
        return this.actual.derecho.data;
    }

    /**
     * Es la clase del Nodo, que también implementa la interfaz Serializable
     */
    private class Node implements Serializable{
        String data;
        Node izquierdo;
        Node derecho;

        /**
         * Constructor del Nodo
         * @param data el dato que va a tener el Nodo
         */
        public Node(String data){
            this.data = data;
            izquierdo = null;
            derecho = null;
        }

    }



}
