package Evidencia2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Clase grafo, la cual contiene todas las características en común de los grafos
 */
public class Grafo {
    protected final HashMap<Vertice, ArrayList<Arista>> vertices = new HashMap<>();
    protected final HashMap<String, Vertice> nombreVertices = new HashMap<>();

    /**
     * Añade un vértice al grafo
     * @param name nombre del vértice
     */
    public void addVertice(String name){
        Vertice vertice = new Vertice(name);
        vertices.put(vertice, new ArrayList<>());
        nombreVertices.put(name, vertice);
    }

    /**
     * Añade una arista al grafo, conectando dos vértices
     * @param v1 vértice 1
     * @param v2 vértice 2
     * @param weight peso de la arista
     */
    public void addArista(String v1, String v2, double weight){
        Vertice vertice1 = new Vertice(v1);
        Vertice vertice2 = new Vertice(v2);
        Arista arista = new Arista(vertice1, vertice2, weight);

        if (!vertices.containsKey(vertice1)) {
            vertices.put(vertice1, new ArrayList<>());
        }
        vertices.get(vertice1).add(arista);
    }

    /**
     * Regresa las adyacencias (vecinos) de los vértices
     * @param vertice el vertice
     * @return los vecinos o adyacencias
     */
    public ArrayList<Arista> getAdyacencias(Vertice vertice){
        return vertices.get(vertice);
    }

    /**
     * Regresa el vértice
     */
    public Vertice getVertice(String name){
        return nombreVertices.get(name);
    }

    /**
     * Obtiene los vecinos o adyacencias de cierto vértice
     * @param vertice vertice
     * @return los vecinos
     */
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

    /**
     * Es la clase encargada de los vértices
     */
    public class Vertice{
        public String getName() {
            return name;
        }

        public Vertice(String name) {
            this.name = name;
        }

        protected final String name;

        /**
         * Se encarga de comparar un objeto para corroborar si es el vértice que se está buscando
         * @param o el objeto dado
         * @return si es igual o no
         */
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

    /**
     * Es la clase encargada de las aristas
     */
    public class Arista{

        protected final Vertice v1;
        protected final Vertice v2;
        protected final double weight;

        /**
         * Es el constructor de la clase
         * @param v1 vértice 1
         * @param v2 vértice 2
         * @param weight peso de la arista
         */
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
