package com.itk.lesson._5.synchronize;

public class ComplexTask implements Runnable {

    private int id;

    public ComplexTask(int id) {
        this.id = id;
    }

    public void execute() {
        try {
            System.out.println("Worker " + id + " is active. Thread name: " + Thread.currentThread().getName());
            Thread.sleep(500); //simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Worker " + id + " has been completed");
    }

    @Override
    public void run() {
        execute();
    }
}
