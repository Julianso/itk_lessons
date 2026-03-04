package com.itk.lesson._9;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTest {

    public static void main(String[] args) {

        int n = 10; // Вычисление факториала для числа 10

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Факториал " + n + "! = " + result);

    }
}

