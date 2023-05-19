package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

public class Clients implements Runnable {

    Logger LOGGER = LogManager.getLogger(Clients.class);

    private final int clientID;
    private final ConnectionPool connectionPool;

    public Clients(int clientID, ConnectionPool connectionPool) {
        this.clientID = clientID;
        this.connectionPool = connectionPool;
    }

    public int getID() {
        return this.clientID;
    }

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        if (connection != null) {
            LOGGER.info("[Client] The connection is acquired by client: " + clientID);
            connection.doSomethingWithDB(this);
            connectionPool.releaseConnection(connection);
            LOGGER.info("[Client] The connection was released by client: " + clientID);
        } else {
            LOGGER.error("[Client] The connection is null");
        }
    }

//    @Override
//    public Object call() throws Exception {
//        Connection connection = connectionPool.getConnection();
//        if (connection != null) {
//            LOGGER.info("[Client] The connection is acquired by client: " + clientID);
//            connection.doSomethingWithDB(this);
//            connectionPool.releaseConnection(connection);
//            LOGGER.info("[Client] The connection was released by client: " + clientID);
//        } else {
//            LOGGER.error("[Client] The connection is null");
//        }
//        return connection;
//    }


}
