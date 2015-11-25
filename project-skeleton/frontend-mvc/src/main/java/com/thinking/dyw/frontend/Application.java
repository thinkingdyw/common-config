package com.thinking.dyw.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:conf/application.xml" })
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @SuppressWarnings("unused")
    private static ApplicationContext ctx    = null;

    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        logger.info("starting application....");
        try {
            ctx = SpringApplication.run(Application.class, args);
            logger.info("application started!");
        } catch (Exception e) {
            logger.error("application start fail!", e);
        }
    }
}