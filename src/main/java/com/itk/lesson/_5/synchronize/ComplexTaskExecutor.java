package com.itk.lesson._5.synchronize;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {

    private final int tasksCount;
    private final CyclicBarrier barrier;

    public ComplexTaskExecutor(int tasksCount) {
        this.tasksCount = tasksCount;
        this.barrier = new CyclicBarrier(tasksCount, () -> System.out.println("All threads completed"));
    }

    public void executeTasks(int tasksCount) {

        ExecutorService executor = Executors.newFixedThreadPool(tasksCount);

        for (int i = 0; i < tasksCount; i++) {
            executor.submit(() -> {
                try {
                    ComplexTask task = new ComplexTask((int) (Math.random() * 1000));
                    task.run();
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
