import Evidencia2.Grafo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GrafoTest {
    private Grafo grafo;

    @Before
    public void init() {
        final double PESO_NEUTRO = 0;
        grafo = new Grafo();
        // nombres de vertices
        final String CINCO = "5";
        final String CUATRO = "4";
        final String TRES = "3";
        final String OCHO = "8";
        final String QUINCE = "15";
        final String DIEZ = "10";
        final String NUEVE = "9";

        // agregar vertices
        grafo.addVertice(CINCO);
        grafo.addVertice(CUATRO);
        grafo.addVertice(TRES);
        grafo.addVertice(OCHO);
        grafo.addVertice(QUINCE);
        grafo.addVertice(DIEZ);
        grafo.addVertice(NUEVE);

        // agregar aristas
        grafo.addArista(CINCO,OCHO,PESO_NEUTRO);
        grafo.addArista(OCHO,CINCO,PESO_NEUTRO);

        grafo.addArista(CINCO,CUATRO,PESO_NEUTRO);
        grafo.addArista(CUATRO,CINCO,PESO_NEUTRO);

        grafo.addArista(CUATRO,OCHO,PESO_NEUTRO);
        grafo.addArista(OCHO,CUATRO,PESO_NEUTRO);

        grafo.addArista(CUATRO,TRES,PESO_NEUTRO);
        grafo.addArista(TRES,CUATRO,PESO_NEUTRO);

        grafo.addArista(TRES,OCHO,PESO_NEUTRO);
        grafo.addArista(OCHO,TRES,PESO_NEUTRO);

        grafo.addArista(TRES,DIEZ,PESO_NEUTRO);
        grafo.addArista(DIEZ,TRES,PESO_NEUTRO);

        grafo.addArista(OCHO,QUINCE,PESO_NEUTRO);
        grafo.addArista(QUINCE,OCHO,PESO_NEUTRO);

        grafo.addArista(QUINCE,NUEVE,PESO_NEUTRO);
        grafo.addArista(NUEVE,QUINCE,PESO_NEUTRO);

        grafo.addArista(NUEVE,DIEZ,PESO_NEUTRO);
        grafo.addArista(DIEZ,NUEVE,PESO_NEUTRO);

    }

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
}
