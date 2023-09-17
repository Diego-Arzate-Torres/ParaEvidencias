package edu.diego.arzate.torres.Modulo1.evidencia1.process;


import java.util.PriorityQueue;

public class queue <E> {
    private PriorityQueue<E> queue;
    private int maxSize;

    public queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new PriorityQueue<>(maxSize);
    }

    public E peek() {
        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void offer(E element) {
        if(queue.size() < maxSize) {
            queue.offer(element);
            System.out.println("Elemento " + element + " agregado a la cola.");
        } else {
            System.out.println("La cola está llena. Elemento " + element + " rechazado.");
        }
    }

    public E poll() {
        if (!queue.isEmpty()) {
            E element = queue.poll();
            System.out.println("Elemento " + element + " eliminado de la cola.");
            return element;
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }

    public void showQueue() {
        System.out.println("Estado actual de la cola: " + queue);
    }
}
