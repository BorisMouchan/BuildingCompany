package com.solvd.laba.threads;

public class Main {

    public static void main(String[] args) {

        int maxConnections = 3;
        int initialConnections = 5;
        ConnectionPool connectionPool = new ConnectionPool(maxConnections);

        for (int i = 0; i < initialConnections; i++) {
            Clients client = new Clients(i+1, connectionPool);
            new Thread(client).start();
        }
    }
}
