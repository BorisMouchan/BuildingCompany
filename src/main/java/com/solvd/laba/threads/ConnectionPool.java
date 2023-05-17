package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;
import java.util.concurrent.Semaphore;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static int maxConnections;
    private Semaphore semaphore;
    public static Vector<Connection> freeConnections;
    public static Vector<Connection> usedConnections;

    public ConnectionPool(int maxConnections, int initialConnections) {
        this.maxConnections = maxConnections;
        this.semaphore = new Semaphore(maxConnections);
        if(maxConnections<initialConnections){
            initialConnections=maxConnections;
        }
        freeConnections = new Vector<>(maxConnections);
        usedConnections = new Vector<>();
    }

    public Connection getConnection() {
        try {
            semaphore.acquire();
            //Only one thread at a time can access the below = Thread-safe
            synchronized (this) {
                    Connection connection = new Connection();
                    int capacity = freeConnections.capacity();
                    if (capacity==0) {
                        return null;
                    }else {
                        if (usedConnections == null) {
                            //if connection[i] is empty - then we lazy initialize it
                            usedConnections.add(connection);
                            capacity--;
                        }
                        return connection;
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //if no unused connection was find in the array - we return null
        return null;
    }

    public void releaseConnection(Connection connection) {
        synchronized (this) {
            for (int i = 0; i < maxConnections; i++) {
                if (usedConnections.contains(connection)) {
                    semaphore.release();
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
