package Queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue = A FIFO data structure with elements with higher priority first before lower priority
 */

public class PriorityQueues {

    public static void main(String[] args) {

        // Standard Order
        // Queue<Double> queue = new PriorityQueue<>();

        // reversed Order
        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
