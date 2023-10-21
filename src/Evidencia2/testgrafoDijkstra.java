package Evidencia2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testgrafoDijkstra {
    public static void main(String[] args) {
        @Test
        public void testGrafo() {
            grafodijkstra.Grafo grafo = new grafodijkstra.Grafo();

            // Añadir vértices
            grafo.addVertice("A");
            grafo.addVertice("B");
            grafo.addVertice("C");

            // Añadir aristas
            grafo.addArista("A", "B", 1.0);
            grafo.addArista("B", "C", 2.0);
            grafo.addArista("C", "A", 3.0);

            // Comprobar que los vértices y las aristas se añadieron correctamente
            assertNotNull(grafo.getAdyacencias(new grafodijkstra.Grafo.Vertice("A")));
            assertNotNull(grafo.getAdyacencias(new grafodijkstra.Grafo.Vertice("B")));
            assertNotNull(grafo.getAdyacencias(new grafodijkstra.Grafo.Vertice("C")));

            assertEquals(1, grafo.getAdyacencias(new grafodijkstra.Grafo.Vertice("A")).size());
            assertEquals(1, grafo.getAdyacencias(new grafodijkstra.Grafo.Vertice("B")).size());
            assertEquals(1, grafo.getAdyacencias(new grafodijkstra.Grafo.Vertice("C")).size());
        }
}
