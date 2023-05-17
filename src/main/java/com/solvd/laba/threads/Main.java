package com.solvd.laba.threads;

public class Main {

    public static void main(String[] args) {

        int maxConnections = 5;
        int initialConnections = 7;
        ConnectionPool connectionPool = new ConnectionPool(maxConnections,initialConnections);

        for (int i = 0; i < initialConnections; i++) {
            Clients client = new Clients(i + 1, connectionPool);
            new Thread(client).start();
        }

    }

}
