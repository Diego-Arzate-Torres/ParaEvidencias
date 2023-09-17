package edu.diego.arzate.torres.Modulo1.evidencia1.process;


import java.util.LinkedList;
import java.util.Optional;

/**
 * Esta clase representa una estructura de datos de tipo Pila.
 * @param <E> el tipo de elementos en esta Pila
 */
public class Stack<E>  {

    /**
     * La lista subyacente utilizada para implementar la Pila.
     */
    public LinkedList<E> lista= new LinkedList<>();

    /**
     * Verifica si la Pila está vacía.
     * @return verdadero si la Pila está vacía, falso en caso contrario
     */
    public boolean isEmpty() {

        return (lista.size() == 0);
    }

    /**
     * Elimina y devuelve el elemento superior de la Pila.
     * @return un Optional que contiene el elemento superior de la Pila, o un Optional vacío si la Pila está vacía
     */
    public Optional<E> pop() {
        if (lista.size()!=0) {
            Optional<E> removedData = (Optional<E>) lista.get(0);
            lista.removeFirst();
            return removedData;
        }
        return Optional.empty();
    }


    /**
     * Devuelve el elemento superior de la Pila sin eliminarlo.
     * @return un Optional que contiene el elemento superior de la Pila, o un Optional vacío si la Pila está vacía
     */
    public Optional<E> peek() {
        if (lista.size()!=0) {
            return (Optional<E>) lista.get(0);
        }
        return Optional.empty();
    }


    /**
     * Empuja un elemento en la parte superior de la Pila.
     * @param element el elemento a ser empujado en la parte superior de la Pila
     * @throws IllegalArgumentException si el elemento es nulo
     */
    public void push(E element){
        if (element == null) {
            throw new IllegalArgumentException("el elemento no puede ser nulo");
        } else {
            lista.addFirst(element);
        }
    }

    /**
     * Devuelve el tamaño de la Pila.
     * @return el tamaño de la Pila
     */
    public int size() {

        return lista.size();
    }



}

