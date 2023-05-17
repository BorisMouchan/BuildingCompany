package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clients implements Runnable{

    private static int clientID;
    private ConnectionPool connectionPool;

    public Clients(int clientID, ConnectionPool connectionPool) {
        this.clientID = clientID;
        this.connectionPool = connectionPool;
    }

    public static int getID() {
        return clientID;
    }

    @Override
    public void run() {
        Logger LOGGER = LogManager.getLogger(Clients.class);
        Connection connection = connectionPool.getConnection();
        if (connection != null) {
            LOGGER.info("[Client] The connection is acquired by client: " + this.getID());
            connection.doSomethingWithDB(this);
            connectionPool.releaseConnection(connection);
            LOGGER.info("[Client] The connection was released by client: " + this.getID());
        } else {
            LOGGER.error("[Client] The connection is null");
        }
    }

}
