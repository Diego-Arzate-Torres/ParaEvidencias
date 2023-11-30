import Evidencia2.Grafo;
import Evidencia2.GrafoDijkstra;
import Evidencia2.GrafoPrim;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Es la clase encarga de llevar a cabo los test de los grafos Dijkstra y Prim
 */
public class GrafoTest {
    private Grafo grafoDijkstra = new GrafoDijkstra(null, null, 0.0) ;
    private Grafo grafoPrim = new GrafoPrim(null, null, 0.0);

    /**
     * Crea el grafo, añadiendo los vértices y las aristas, así como agregando peso a éstas
     */
    @Before
    public void init() {

        grafoDijkstra.addVertice("1");
        grafoDijkstra.addVertice("2");
        grafoDijkstra.addVertice("3");
        grafoDijkstra.addVertice("4");
        grafoDijkstra.addVertice("5");


        grafoDijkstra.addArista("1", "2", 1);
        grafoDijkstra.addArista("2", "3", 1);
        grafoDijkstra.addArista("3", "4", 1);
        grafoDijkstra.addArista("4", "5", 1);

    }
    @Test
    public void testDijkstraAlgorithm(){
        System.out.println("TEST: Dijkstra Algorithm");
        Grafo.Vertice target = grafoDijkstra.new Vertice("10");
        assertEquals(new GrafoDijkstra(grafoDijkstra,"5", 10.0), target);
        System.out.println("................................");
    }
/*
    @Test
    public void testBreadthFirstSuccess(){
        System.out.println("TEST: BreadthFirstSuccess");
        Grafo.Vertice target = grafo.new Vertice("10");
        assertEquals(SearchGraph.breadthFirstSearch(grafo,"5","10"),target);
        System.out.println("................................");
    }
    @Test
    public void testBreadthFirstFail(){
        System.out.println("TEST: BreadthFirstFail");
        Grafo.Vertice target = grafo.new Vertice("10");
        assertNotEquals(SearchGraph.breadthFirstSearch(grafo,"5","20"),target);
        System.out.println("................................");
    }

    @Test
    public void testDeepFirstSuccess(){
        System.out.println("TEST: DeepFirstSuccess");
        Grafo.Vertice target = grafo.new Vertice("10");
        assertEquals(SearchGraph.deepFirstSearch(grafo,"5","10"),target);
        System.out.println("................................");
    }
    @Test
    public void testDeepFirstFail(){
        System.out.println("TEST: DeepFirstFail");
        Grafo.Vertice target = grafo.new Vertice("10");
        assertNotEquals(SearchGraph.deepFirstSearch(grafo,"5","20"),target);
        System.out.println("................................");
    }

 */
    }
