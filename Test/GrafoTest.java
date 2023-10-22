import Evidencia2.Grafo;
import Evidencia2.GrafoDijkstra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GrafoTest {
    public Grafo grafo = new GrafoDijkstra(null, null, 0.0) ;

    @Before
    public void init() {

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
    public void testDijkstraAlgorithm(){
        System.out.println("TEST: Dijkstra Algorithm");
        Grafo.Vertice target = grafo.new Vertice("10");
        assertEquals(new GrafoDijkstra(grafo,"5", 10.0), target);
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
