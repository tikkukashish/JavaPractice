package com.edtech.my_edtech_product;

import java.util.PriorityQueue;
import java.util.Iterator;

public class PriorityQueuePrograms {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);
        pq.add(40);

        System.out.println("Priority Queue: " + pq);
        System.out.println("Head element using peek(): " + pq.peek());
        System.out.println("Removed element using poll(): " + pq.poll());
        System.out.println("Priority Queue after poll(): " + pq);
        pq.remove(20);
        System.out.println("After removing 20: " + pq);
        System.out.println("Iteration using Iterator:");

        Iterator<Integer> itr = pq.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}