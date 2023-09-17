package evidencia1.process;


import java.util.*;


public class priorityQueue<E> extends Stack<Integer> {
    private int cap;
    private LinkedList<Integer> lista;
    private LinkedList<E> queue;
    private int maxSize;

    public void PriorityQueueWithCap(int cap) {
        this.cap = cap;
        this.lista = new LinkedList<>();
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    public void push(Integer val) {
        if (this.lista.size() < cap) {
            this.lista.add(val);
            this.lista.sort(Comparator.reverseOrder());
            System.out.println("Elemento " + val + " agregado a la cola.");
        } else {
            System.out.println("La cola ha alcanzado su tope máximo. Elemento " + val + " rechazado.");
        }
    }



    public void display() {
        System.out.println("Estado actual de la cola: " + this.lista);
    }

    public void inverse() {
        LinkedList<E> temp = new LinkedList<>();

        while (!queue.isEmpty()) {
            temp.addFirst(queue.remove());
        }

        queue = temp;
    }
    public void offer(Integer element) {
        if(queue.size() < maxSize) {
            queue.offer((E) element);
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
            throw new NoSuchElementException("La cola está vacía.");
        }
    }






    public void showQueue() {
        System.out.println("Estado actual de la cola: " + queue);
    }

}