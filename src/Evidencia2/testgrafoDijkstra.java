package Evidencia2;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testgrafoDijkstra {
    public GrafoDijkstra grafo;

    @Before
    public void setUp() {
        grafo = new GrafoDijkstra();
        grafo.addVertice("1");
        grafo.addVertice("2");
        grafo.addVertice("3");
        grafo.addVertice("4");
        grafo.addVertice("5");

        grafo.addArista("1", "2", 1);
        grafo.addArista("2", "3", 1);
        grafo.addArista("3", "4", 1);
        grafo.addArista("4", "5", 1);
    }

    @Test
    public void testBreadthFirstSearch() {
        GrafoDijkstra.Vertice start = grafo.getVertice("1");
        GrafoDijkstra.Vertice end = grafo.getVertice("5");

        GrafoDijkstra.Vertice result = SearchGraph.breadthFirstSearch(grafo, start.getName(), end.getName());

        assertEquals(end, result);
    }

    @Test
    public void testDeepFirstSearch() {
        GrafoDijkstra.Vertice start = grafo.getVertice("1");
        GrafoDijkstra.Vertice end = grafo.getVertice("5");

        GrafoDijkstra.Vertice result = SearchGraph.deepFirstSearch(grafo, start.getName(), end.getName());

        assertEquals(end, result);
    }
}
