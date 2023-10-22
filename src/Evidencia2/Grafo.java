package Evidencia2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Grafo {
    protected final HashMap<Vertice, ArrayList<Arista>> vertices = new HashMap<>();
    protected final HashMap<String, Vertice> nombreVertices = new HashMap<>();

    public void addVertice(String name){
        Vertice vertice = new Vertice(name);
        vertices.put(vertice, new ArrayList<>());
        nombreVertices.put(name, vertice);
    }

    public void addArista(String v1, String v2, double weight){
        Vertice vertice1 = new Vertice(v1);
        Vertice vertice2 = new Vertice(v2);
        Arista arista = new Arista(vertice1, vertice2, weight);

        if (!vertices.containsKey(vertice1)) {
            vertices.put(vertice1, new ArrayList<>());
        }
        vertices.get(vertice1).add(arista);
    }

    public ArrayList<Arista> getAdyacencias(Vertice vertice){
        return vertices.get(vertice);
    }

    public Vertice getVertice(String name){
        return nombreVertices.get(name);
    }

    public ArrayList<Vertice> getVecinos(Vertice vertice) {
        ArrayList<Vertice> vecinos = new ArrayList<>();
        for (Arista arista : vertices.get(vertice)) {
            vecinos.add(arista.getV2());
        }
        return vecinos;
    }

    @Override
    public String toString() {
        return vertices.toString();
    }

    public class Vertice{
        public String getName() {
            return name;
        }

        public Vertice(String name) {
            this.name = name;
        }

        protected final String name;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertice)) return false;
            Vertice vertice = (Vertice) o;
            return Objects.equals(name, vertice.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public class Arista{

        protected final Vertice v1;
        protected final Vertice v2;
        protected final double weight;

        public Arista(Vertice v1, Vertice v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        public Vertice getV1(){
            return v1;
        }
        public Vertice getV2(){
            return v2;
        }
        public double getWeight(){
            return weight;
        }

    }

}
