package com.solvd.laba.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    public void doSomethingWithDB(Clients client) {
        Logger LOGGER = LogManager.getLogger(Connection.class);
        LOGGER.info("[Connection] is used by client: " + client.getID());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
