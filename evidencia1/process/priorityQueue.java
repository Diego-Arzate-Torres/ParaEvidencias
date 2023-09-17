package edu.diego.arzate.torres.Modulo1.evidencia1.process;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;


public class priorityQueue extends Stack<Integer> {
    private int cap;
    private LinkedList<Integer> lista;

    public void PriorityQueueWithCap(int cap) {
        this.cap = cap;
        this.lista = new LinkedList<>();
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

    public Optional<Integer> pop() {
        if (!this.lista.isEmpty()) {
            int val = this.lista.removeFirst();
            System.out.println("Elemento " + val + " eliminado de la cola.");
            return Optional.of(val);
        } else {
            System.out.println("La cola está vacía.");
            return Optional.empty();
        }
    }

    public void display() {
        System.out.println("Estado actual de la cola: " + this.lista);
    }
}