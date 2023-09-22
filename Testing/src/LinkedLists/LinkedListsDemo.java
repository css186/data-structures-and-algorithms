package LinkedLists;

import java.util.LinkedList;

/**
 * singly linkedlist [data|address]
 * 1. no index -> searching is O(N)
 * 2. pointer to next address -> insertion/deletion is quick O(1)
 *
 * doubly linkedlist [address|data|address]
 * 1. have prev and next address -> can traverse both way
 * 2. uses more memories
 *
 * Advantages:
 * 1. Dynamic Data Structure
 * 2. Insertion Deletion is easy
 * 3. No/Low memory waste
 *
 * Disadvantages:
 * 1. Greater memory usage
 * 2. No random access of elements
 * 3. accessing searching is complex
 *
 * General Usage:
 * 1. implement Stacks/Queue
 * 2. GPS navigation
 * 3. music playlist
 *
 */

public class LinkedListsDemo {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        // treat linkedlist as a stack
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");
        linkedList.pop();

        System.out.println(linkedList);

        // treat linkedlist as a queue
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.offer("A");
        linkedList1.offer("B");
        linkedList1.offer("C");
        linkedList1.offer("D");
        linkedList1.offer("F");
        linkedList1.poll();

        System.out.println(linkedList1);


        // insertion
        linkedList.add(4, "E");
        System.out.println(linkedList);

        // deletion
        linkedList.remove("E");
        System.out.println(linkedList);

        // peek
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());

        // add or remove first/last
        linkedList.addFirst("0");
        linkedList.addLast("E");
        System.out.println(linkedList);

        String first = linkedList.removeFirst();
        System.out.println(first);
        String last = linkedList.removeLast();
        System.out.println(last);

    }
}
