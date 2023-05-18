package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;
import java.util.concurrent.Semaphore;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static int maxConnections;
    public static Vector<Connection> freeConnections = new Vector<>();
    public static Vector<Connection> usedConnections = new Vector<>();
    public static Semaphore semaphore;

    public ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.semaphore = new Semaphore(maxConnections);
        initializeConnectionPool(maxConnections);
    }

    public Connection getConnection() {
        try {
            semaphore.acquire();
            synchronized (this) {
                for (int i = 0; i < maxConnections; i++) {
                    if (!freeConnections.isEmpty()) {
                        Connection connection = new Connection();
                        usedConnections.add(i,connection);
                        freeConnections.remove(freeConnections.size() - 1);
                    }
                    return usedConnections.get(i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initializeConnectionPool(int maxConnections) {
        for (int i =0; i<maxConnections;i++) {
            freeConnections.add(new Connection());
        }
    }
    public void releaseConnection(Connection connection) {
        synchronized (this) {
            for(int i=0;i<maxConnections;i++) {
                if (usedConnections.contains(connection)) {
                    semaphore.release();
                    freeConnections.add(new Connection());
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
