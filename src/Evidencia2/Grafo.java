package Evidencia2;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {

    @Override
    public String toString() {
        //TODO
    }

    public ArrayList<Arista> getAdyacencias(Vertice vertice){
        //TODO
    }

    private final HashMap<Vertice, ArrayList<Arista>> vertices;

    public Grafo() {
        //TODO
    }

    public void addVertice(String name) {
        //TODO
    }

    public void addArista(String v1, String v2, double weight) {
        //TODO
    }

    public class Vertice {
        private final String name;

        @Override
        public boolean equals(Object o) {
            //TODO
        }

        @Override
        public int hashCode() {
            //TODO
        }

        public String getName() {
            //TODO
        }

        public Vertice(String name) {
            //TODO
        }
    }

    public class Arista {
        private final Vertice v1;
        private final Vertice v2;

        private final double weight;

        @Override
        public String toString() {
            //TODO
        }

        public Vertice getV1() {
            //TODO
        }

        public Vertice getV2() {
            //TODO
        }

        public double getWeight() {
            //TODO
        }

        public Arista(Vertice v1, Vertice v2, double weight) {
            //TODO
        }
    }
}
