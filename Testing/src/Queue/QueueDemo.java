package Queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Uses of Queues:
 * 1. Keyboard Buffer (letters should be appeared on the screen in the order that they're pressed
 * 2. Printer Queues
 * 3. Used in LinkedList, PriorityQueues, Breadth-first search
 */

public class QueueDemo {
    public static void main(String[] args) {

        // queue is an interface, cannot be instantiated directly
        // should instantiate queue by using other classes
        Queue<String> queue = new LinkedList<>();

        /**
         * add = enqueue, offer()
         * remove = dequeue, poll()
         */

        System.out.println(queue.isEmpty());

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        // the following method came from the Collection class
        // check empty
        System.out.println(queue.isEmpty());

        System.out.println(queue.size());

        System.out.println(queue.contains("Harold"));

        // usually used the following method to manipulate data
        System.out.println(queue.peek());
        queue.poll();
        queue.poll();
        System.out.println(queue.peek());

        System.out.println(queue);


    }
}
