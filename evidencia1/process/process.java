package evidencia1.process;


import java.util.Random;

public class process implements Comparable<process> {
    private static int priority;
    private int arrivalTime;
    private int serviceTime;

    public process(int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime) {
        Random rand = new Random();
        priority = rand.nextInt(5) + 1;
        arrivalTime = rand.nextInt(maxArrivalTime - minArrivalTime + 1) + minArrivalTime;
        serviceTime = rand.nextInt(maxServiceTime - minServiceTime + 1) + minServiceTime;
    }

    public static int getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public int compareTo(process other) {
        return other.priority - this.priority; // Orden descendente de prioridad
    }

    @Override
    public String toString() {
        return "Process{" +
                "priority=" + priority +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}
