package com.hw3.pingpong;

public class Pingpong {
    private String state;

    public Pingpong(String pingPong) {
        state = pingPong;
    }

    public synchronized void print(String pingPong) {
        while (state.equals(pingPong)) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(pingPong);
        state = pingPong;
        notify();
    }
}
