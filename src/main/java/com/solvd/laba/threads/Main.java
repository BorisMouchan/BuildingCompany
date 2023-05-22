package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {


        int maxConnections = 3;
        int initialConnections = 5;
        ConnectionPool connectionPool = new ConnectionPool(maxConnections);

        //CompletableFuture with CompletionStage
        for (int i = 0; i < initialConnections; i++) {
            Clients client = new Clients(i+1, connectionPool);
            ExecutorService executor = Executors.newFixedThreadPool(maxConnections);
            CompletableFuture.runAsync(() -> new Thread(client).start(), executor).thenRun(executor::shutdown);

        }

        // future
//        for (int i = 0; i < initialConnections; i++) {
//            Clients client = new Clients(i + 1, connectionPool);
//            ExecutorService executor = Executors.newFixedThreadPool(maxConnections);
//            Future<?> future = executor.submit(client);
//            future.get();
//            LOGGER.info("Shutdown");
//            executor.shutdown();
//        }
            // standart
//        for (int i = 0; i < initialConnections; i++) {
//            Clients client = new Clients(i+1, connectionPool);
//            new Thread(client).start();
//        }
    }
}
