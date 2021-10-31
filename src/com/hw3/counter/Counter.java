package com.hw3.counter;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private volatile long value;
    private final ReentrantLock locker = new ReentrantLock();

    public Counter(long startValue) {
        this.value = startValue;
    }

    public void increment() {
        locker.lock();
        value++;
        locker.unlock();
    }

    public void decrement() {
        locker.lock();
        value--;
        locker.unlock();
    }

    public long get() {
        return value;
    }

}
