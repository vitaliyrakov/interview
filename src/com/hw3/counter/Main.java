package com.hw3.counter;

public class Main {
    private static final int CNT = 5000;

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter(0);
        System.out.println("Начальное состояние счетчика: " + counter.get());

        Thread increment = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                counter.increment();

            }
        });

        Thread decrement = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                counter.decrement();
            }
        });

        increment.start();
        decrement.start();

        increment.join();
        decrement.join();
        System.out.println("Конечное состояние счетчика: " + counter.get());
    }
}
