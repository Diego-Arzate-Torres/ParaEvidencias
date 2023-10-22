package Evidencia2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class GrafoPrim extends Grafo{
    /*
    public class Grafo {
        private final HashMap<Vertice, ArrayList<Arista>> vertices;

        public Grafo() {
            this.vertices = new HashMap<>();
        }

        public void addVertice(String name) {
            this.vertices.put(new Vertice(name), new ArrayList<>());
        }

        public void addArista(String v1, String v2, double weight) {
            Arista arista = new Arista(new Vertice(v1), new Vertice(v2), weight);
            this.vertices.get(new Vertice(v1)).add(arista);
            this.vertices.get(new Vertice(v2)).add(arista);
        }

        public ArrayList<Arista> getAdyacencias(Vertice vertice) {
            return this.vertices.get(vertice);
        }

        @Override
        public String toString() {
            return "Grafo{" +
                    "vertices=" + vertices +
                    '}';
        }

        public class Vertice {
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
                return Objects.equals(getName(), vertice.getName());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getName());
            }
        }

        public class Arista implements Comparable<Arista> {
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
                        "v1=" + v1.getName() +
                        ", v2=" + v2.getName() +
                        ", weight=" + weight +
                        '}';
            }

            @Override
            public int compareTo(Arista o) {
                return Double.compare(this.weight, o.getWeight());
            }
        }


     */
        // Implementación del algoritmo de Prim
        public Grafo primMST() {
            Grafo mst = new Grafo();
            PriorityQueue<Arista> pq = new PriorityQueue<>();
            // Seleccionamos un vértice inicial arbitrario
            Vertice initialVertex = this.vertices.keySet().iterator().next();
            mst.addVertice(initialVertex.getName());
            pq.addAll(this.getAdyacencias(initialVertex));

            while (mst.vertices.size() < this.vertices.size()) {
                Arista minEdge = pq.poll();
                if (minEdge == null) break;  // No hay más aristas en la cola de prioridad
                if (mst.vertices.containsKey(minEdge.getV1()) && mst.vertices.containsKey(minEdge.getV2()))
                    continue;  // Evitamos ciclos
                Vertice newVertex = mst.vertices.containsKey(minEdge.getV1()) ? minEdge.getV2() : minEdge.getV1();
                mst.addVertice(newVertex.getName());
                mst.addArista(minEdge.getV1().getName(), minEdge.getV2().getName(), minEdge.getWeight());
                pq.addAll(this.getAdyacencias(newVertex));
            }
            return mst;
        }

}

