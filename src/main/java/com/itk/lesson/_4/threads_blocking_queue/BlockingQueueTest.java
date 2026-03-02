package com.itk.lesson._4.threads_blocking_queue;

public class BlockingQueueTest {

    static final int QUEUE_CAPACITY = 20;
    static final int NUMBER_OF_ITERATIONS = 100;


    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new BlockingQueue(QUEUE_CAPACITY);

        Thread producerThread = new Thread(() -> {
            for(int i = 0; i <= NUMBER_OF_ITERATIONS; i++) {
                queue.enqueue(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                int value = queue.dequeue();
                System.out.println("Used value " + value + " from queue");
                if (value == NUMBER_OF_ITERATIONS) {
                    System.out.println("Consumer thread has completed");
                    return;
                }
            }
        });

        producerThread.start();

        consumerThread.start();

        producerThread.join();

        consumerThread.join();

        System.out.println("End of main process");
    }

}
