package com.hw3.pingpong;

public class Main {
    private static final int CNT = 10;

    public static void main(String[] args) {
        Pingpong pingPong = new Pingpong("ping");

        Thread ping = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                pingPong.print("ping");
            }
        });

        Thread pong = new Thread(() -> {
            for (int i = 0; i < CNT; i++) {
                pingPong.print("pong");
            }
        });

        ping.start();
        pong.start();
    }
}
