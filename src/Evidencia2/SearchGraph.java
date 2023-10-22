package Evidencia2;

import java.util.*;

public class SearchGraph {
    public static GrafoDijkstra.Vertice breadthFirstSearch(GrafoDijkstra grafo, String inicio, String objetivo) {
        Queue<GrafoDijkstra.Vertice> queue = new LinkedList<>();
        Set<GrafoDijkstra.Vertice> visited = new HashSet<>();

        GrafoDijkstra.Vertice start = grafo.getVertice(inicio);
        queue.add(start);

        while (!queue.isEmpty()) {
            GrafoDijkstra.Vertice current = queue.poll();
            visited.add(current);

            if (current.getName().equals(objetivo)) {
                return current;
            }

            for (GrafoDijkstra.Arista arista : grafo.getAdyacencias(current)) {
                GrafoDijkstra.Vertice neighbor = arista.getV2();
                if (!visited.contains(neighbor)) {
                    queue.add(grafo.getVertice(neighbor.getName()));
                }
            }
        }

        return null;  // Retorna null si no se encuentra el objetivo
    }

    public static GrafoDijkstra.Vertice deepFirstSearch(GrafoDijkstra grafo, String inicio, String objetivo) {
        Stack<GrafoDijkstra.Vertice> stack = new Stack<>();
        Set<GrafoDijkstra.Vertice> visited = new HashSet<>();

        GrafoDijkstra.Vertice start = grafo.getVertice(inicio);
        stack.push(start);

        while (!stack.isEmpty()) {
            GrafoDijkstra.Vertice current = stack.pop();
            visited.add(current);

            if (current.getName().equals(objetivo)) {
                return current;
            }

            for (GrafoDijkstra.Arista arista : grafo.getAdyacencias(current)) {
                GrafoDijkstra.Vertice neighbor = arista.getV2();
                if (!visited.contains(neighbor)) {
                    stack.push(grafo.getVertice(neighbor.getName()));
                }
            }
        }

        return null;  // Retorna null si no se encuentra el objetivo
    }
}

