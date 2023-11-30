package Evidencia2;

import java.util.*;

/**
 * Clase encargada del Grafo Dijkstra, la cual hereda las propiedades de la clase Grafo
 */
public class GrafoDijkstra extends Grafo{
    /**
     * Constructor del grafo
     * @param grafo
     * @param name nombre de las aristas
     * @param weight peso de las aristas
     */
    public GrafoDijkstra(Grafo grafo, String name, Double weight) {
        super();
    }

    /*private final HashMap<GrafoDijkstra.Vertice, ArrayList<GrafoDijkstra.Arista>> vertices = new HashMap<>();
        private final HashMap<String, GrafoDijkstra.Vertice> nombreVertices = new HashMap<>();

        public void addVertice(String name) {

            GrafoDijkstra.Vertice vertice = new GrafoDijkstra.Vertice(name);
            vertices.put(vertice, new ArrayList<>());
            nombreVertices.put(name, vertice);
        }

        public void addArista(String v1, String v2, double weight) {
            GrafoDijkstra.Vertice vertice1 = new GrafoDijkstra.Vertice(v1);
            GrafoDijkstra.Vertice vertice2 = new GrafoDijkstra.Vertice(v2);
            GrafoDijkstra.Arista arista = new GrafoDijkstra.Arista(vertice1, vertice2, weight);

            if (!vertices.containsKey(vertice1)) {
                vertices.put(vertice1, new ArrayList<>());
            }
            vertices.get(vertice1).add(arista);
        }
        public ArrayList<GrafoDijkstra.Arista> getAdyacencias(GrafoDijkstra.Vertice vertice){
            return vertices.get(vertice);
        }

        // Getter para un vértice
        public GrafoDijkstra.Vertice getVertice(String name) {
            return nombreVertices.get(name);
        }


        // Getter para los vecinos de un vértice
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


         */

    /**
     * Implementación del algoritmo de Dijkstra
     * @param inicio es el vértice en el que inicia el recorrido del grafo
     * @return
     */
    public HashMap<Vertice, Double> dijkstra(Vertice inicio) {
        HashMap<Vertice, Double> distancias = new HashMap<>();
        for (Vertice vertice : vertices.keySet()) {
            distancias.put(vertice, Double.MAX_VALUE);
        }
        distancias.put(inicio, 0.0);

        PriorityQueue<Vertice> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            for (Arista arista : vertices.get(actual)) {
                Vertice vecino = arista.getV2();
                double nuevaDistancia = distancias.get(actual) + arista.getWeight();
                if (nuevaDistancia < distancias.get(vecino)) {
                    cola.remove(vecino);
                    distancias.put(vecino, nuevaDistancia);
                    cola.add(vecino);
                }
            }
        }
        return distancias;
    }

 /*   public class Vertice {
        private final String name;

        public Vertice(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

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

     public class Arista {
       private final Vertice v1;
        private final Vertice v2;
        private final double weight;

        public Arista(Vertice v1, Vertice v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public Vertice getV1() {
            return v1;
        }

        public Vertice getV2() {
            return v2;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Arista{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", weight=" + weight +
                    '}';
        }
    }

       */
}