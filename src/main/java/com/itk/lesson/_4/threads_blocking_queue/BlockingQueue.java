package com.itk.lesson._4.threads_blocking_queue;

import java.util.LinkedList;
import java.util.Random;

public class BlockingQueue {

    private final int capacity;
    private final LinkedList<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    void enqueue(int i) {

        synchronized (lock) {
            while (queue.size() == capacity) {

                System.out.println("The queue is full, waiting");

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            queue.add(i);

            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.notify();
        }
    }

    int dequeue() {
        while(true) {

            synchronized (lock) {
                while (size() == 0) {
                    System.out.println("The queue is full, waiting for new items");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int item = queue.pop();
                lock.notify();

                return item;
            }
        }
    }

    int size() {
        return this.queue.size();
    }

}
