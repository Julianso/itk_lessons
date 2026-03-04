package com.itk.lesson._9;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return 1L;
        }

        FactorialTask childTask = new FactorialTask(n - 1);
        childTask.fork();

        return n * childTask.join();
    }
}