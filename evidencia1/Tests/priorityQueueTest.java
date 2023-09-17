package edu.diego.arzate.torres.Modulo1.evidencia1.Tests;

import edu.diego.arzate.torres.Modulo1.evidencia1.process.priorityQueue;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class priorityQueueTest {
    @Test
    public void testPriorityQueue() {
        priorityQueue queue = new priorityQueue();

        // Prueba offer
        assertTrue(queue.offer(3));
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        assertTrue(queue.offer(5));
        assertTrue(queue.offer(4));

        // Prueba cuando la cola está llena
        assertFalse(queue.offer(6));

        // Prueba peek
        assertEquals(Integer.valueOf(1), queue.peek());

        // Prueba poll
        assertEquals(Integer.valueOf(1), queue.poll());
        assertEquals(Integer.valueOf(2), queue.poll());
        assertEquals(Integer.valueOf(3), queue.poll());
        assertEquals(Integer.valueOf(4), queue.poll());
        assertEquals(Integer.valueOf(5), queue.poll());

        // Prueba cuando la cola está vacía
        assertNull(queue.poll());
    }
}
