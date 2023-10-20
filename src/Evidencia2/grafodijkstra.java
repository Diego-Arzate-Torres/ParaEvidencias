package Evidencia2;

import java.util.ArrayList;
import java.util.HashMap;

public class grafodijkstra {
    public class Grafo {
        private final HashMap<Vertice, ArrayList<Arista>> vertices;

        public Grafo() {
            this.vertices = new HashMap<>();
        }

        public void addVertice(String nombre) {
            this.vertices.put(new Vertice(nombre), new ArrayList<>());
        }

        public void addArista(String v1, String v2, double peso) {
            Vertice vertice1 = new Vertice(v1);
            if (!this.vertices.containsKey(vertice1)) {
                this.addVertice(v1);
            }
            this.vertices.get(vertice1).add(new Arista(new Vertice(v2), peso));
        }

        public ArrayList<Arista> getAdyacencias(Vertice vertice) {
            return this.vertices.get(vertice);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Vertice, ArrayList<Arista>> entry : vertices.entrySet()) {
                sb.append("Vertice: ").append(entry.getKey().getNombre()).append("\n");
                sb.append("Adyacencias: \n");
                for (Arista arista : entry.getValue()) {
                    sb.append("\t").append(arista.toString()).append("\n");
                }
            }
            return sb.toString();
        }

        public class Vertice {
            private final String nombre;

            public Vertice(String nombre) {
                this.nombre = nombre;
            }

            public String getNombre() {
                return nombre;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Vertice)) return false;
                Vertice vertice = (Vertice) o;
                return getNombre().equals(vertice.getNombre());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getNombre());
            }
        }

        public class Arista {
            private final Vertice v1;
            private final Vertice v2;
            private final double peso;

            public Arista(Vertice v1, Vertice v2, double peso) {
                this.v1 = v1;
                this.v2 = v2;
                this.peso = peso;
            }

            public Vertice getV1() {
                return v1;
            }

            public Vertice getV2() {
                return v2;
            }

            public double getPeso() {
                return peso;
            }

            @Override
            public String toString() {
                return "Arista{" +
                        "v1=" + v1.getNombre() +
                        ", v2=" + v2.getNombre() +
                        ", peso=" + peso +
                        '}';
            }
        }
    }
}