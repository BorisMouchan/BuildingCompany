package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Semaphore;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static int maxConnections;
    public static Vector<Connection> freeConnections = new Vector<>();
    public static Vector<CompletableFuture<Connection>> usedConnections = new Vector<CompletableFuture<Connection>>();
    public static Semaphore semaphore;

    public ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.semaphore = new Semaphore(maxConnections);
        initializeConnectionPool(maxConnections);
    }

    public CompletionStage<Connection> getConnection() {
        CompletableFuture<Connection> future = new CompletableFuture<>();
        try {
            semaphore.acquire();
            synchronized (this) {
                for (int i = 0; i < maxConnections; i++) {
                    if (!freeConnections.isEmpty()) {
                        int finalI = i;
                        CompletableFuture.supplyAsync(() -> {
                            usedConnections.add(finalI, future);
                            freeConnections.remove(freeConnections.size() - 1);
                            return usedConnections.get(finalI);
                        });
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return future;
    }
    // future
//    public Connection getConnection() {
//
//        try {
//            semaphore.acquire();
//            synchronized (this) {
//                for (int i = 0; i < maxConnections; i++) {
//                    if (!freeConnections.isEmpty()) {
//                        Connection connection = new Connection();
//                        usedConnections.add(i,connection);
//                        freeConnections.remove(freeConnections.size() - 1);
//                    }
//                    return usedConnections.get(i);
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void initializeConnectionPool(int maxConnections) {
        for (int i = 0; i < maxConnections; i++) {
            freeConnections.add(new Connection());
        }
    }

    public void releaseConnection(CompletionStage<Connection> connection) {
        synchronized (this) {
            semaphore.release();
            for (int i = 0; i < maxConnections; i++) {
                    CompletableFuture.runAsync(() -> {
                        if (usedConnections.contains(connection)) {
                            usedConnections.remove(connection);
                            freeConnections.add(new Connection());
                        }
                    });
            }
        }
    }
    //  future
//    public void releaseConnection(Connection connection) {
//        synchronized (this) {
//            for(int i=0;i<maxConnections;i++) {
//                if (usedConnections.contains(connection)) {
//                    semaphore.release();
//                    usedConnections.remove(connection);
//                    freeConnections.add(new Connection());
//                }
//            }
//        }
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}
