package Evidencia2;

import java.util.*;

public class SearchGraph {
    public static Grafo.Vertice breadthFirstSearch(Grafo grafo, String inicio, String objetivo) {
        Queue<Grafo.Vertice> queue = new LinkedList<>();
        Set<Grafo.Vertice> visited = new HashSet<>();

        Grafo.Vertice start = GrafoDijkstra.getVertice(inicio);
        queue.add(start);

        while (!queue.isEmpty()) {
            Grafo.Vertice current = queue.poll();
            visited.add(current);

            if (current.getNombre().equals(objetivo)) {
                return current;
            }

            for (Grafo.Vertice neighbor : grafo.getVecinos(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return null;  // Retorna null si no se encuentra el objetivo
    }

    public static Grafo.Vertice deepFirstSearch(Grafo grafo, String inicio, String objetivo) {
        Stack<Grafo.Vertice> stack = new Stack<>();
        Set<Grafo.Vertice> visited = new HashSet<>();

        Grafo.Vertice start = Grafo.getVertice(inicio);
        stack.push(start);

        while (!stack.isEmpty()) {
            Grafo.Vertice current = stack.pop();
            visited.add(current);

            if (current.getNombre().equals(objetivo)) {
                return current;
            }

            for (Grafo.Vertice neighbor : grafo.getVecinos(current)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }

        return null;  // Retorna null si no se encuentra el objetivo
    }
}
