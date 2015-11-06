package com.thinking.dyw.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        printLnArgs(args);
        
        Server server = new Server();
        
        try {
            server.start();
        } catch (Exception e) {
            logger.error("server start fail!!!", e);
        }
    }

    private static void printLnArgs(String[] args) {
        if (args != null) {
            StringBuilder params = new StringBuilder("[");
            for (String arg : args) {
                params.append(arg).append(",");
            }
            params.append("]");
            logger.debug("receive user params:" + params.toString());
        } else {
            logger.debug("there's no params!");
        }
    }
}
