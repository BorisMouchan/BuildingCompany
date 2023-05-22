package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

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
        CompletionStage<Void> connection = connectionPool.getConnection();
        if (connection != null) {
            LOGGER.info("[Client] The connection is acquired by client: " + clientID);
            LOGGER.info("[Connection] is used by client: " + clientID);
            connectionPool.releaseConnection((CompletableFuture) connection);
            LOGGER.info("[Client] The connection was released by client: " + clientID);
        } else {
            LOGGER.error("[Client] The connection is null");
        }
    }
}
