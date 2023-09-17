package evidencia1.ui;

import evidencia1.process.Element;
import evidencia1.process.process;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CLI {
    private Queue<Element> queue;
    private int minArrivalTime;
    private int maxArrivalTime;
    private int minServiceTime;
    private int maxServiceTime;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Establecer el tope de la cola:");
        int maxSize = scanner.nextInt();
        queue = new LinkedList<Element>();

        System.out.println("Establecer el rango de tiempo de llegada de los elementos:");
        minArrivalTime = scanner.nextInt();
        maxArrivalTime = scanner.nextInt();

        System.out.println("Establecer el rango de tiempo de servicio del servidor:");
        minServiceTime = scanner.nextInt();
        maxServiceTime = scanner.nextInt();

        System.out.println("Iniciar simulación:");
        simulate();
    }

    private void simulate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Random random = new Random();

        // Programar la llegada de elementos.
        executor.scheduleAtFixedRate(() -> {
            int priority = random.nextInt(5) + 1;
            Element element = new Element (priority){
            };
            queue.offer(element);
            queue.size();
        }, 0, getRandomTime(minArrivalTime, maxArrivalTime), TimeUnit.SECONDS);

        // Programar la salida de elementos.
        executor.scheduleAtFixedRate(() -> {
            Element element = queue.poll();
            if (element != null) {
                System.out.println("Elemento con prioridad " + process.getPriority() + " atendido.");
                queue.size();
            }
        }, 0, getRandomTime(minServiceTime, maxServiceTime), TimeUnit.SECONDS);

        // Detener la simulación después de tres minutos.
        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Simulación terminada.");
            queue.size();
        }, 3, TimeUnit.MINUTES);
    }

    private long getRandomTime(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }
}

        