package com.thinking.dyw.backend;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thinking.dyw.backend.service.ThriftBackEndService;
import com.thinking.dyw.backend.service.ThriftBackEndService.Iface;
import com.thinking.dyw.backend.service.ThriftBackEndService.Processor;
import com.thinking.dyw.backend.service.impl.ThriftBackendServiceImpl;

public class Server {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private AtomicBoolean closed = new AtomicBoolean(false);
    BackEndService backEndService = null;
    public void start() throws Exception {
        logger.debug("server starting...");
        startBackEndService();
        logger.debug("server started!!!");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                Server.this.stop();
            }
        }));
        while (!closed.get()) {
            try {
                Thread.sleep(1000);
                logger.debug("server heart ok!");
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
        logger.debug("server stoped!!!");
    }

    private void startBackEndService() {
        BackEndService backEndService = new BackEndService();
        new Thread(backEndService).start();
    }

    protected void stop() {
        logger.debug("server stoping...");
        try {
            backEndService.stop();
        } catch (Exception e) {
            logger.error("", e);
        }
        closed.getAndSet(true);
    }
    
    class BackEndService implements Runnable{
        private TServer server = null;
        @Override
        public void run() {
            try {
                TServerTransport serverTransport = new TServerSocket(9090);
                ThriftBackEndService.Processor<Iface> processor = new Processor<ThriftBackEndService.Iface>(
                    new ThriftBackendServiceImpl());
                server = new TSimpleServer(new Args(serverTransport).processor(processor));
                server.serve();
            } catch (Exception e) {
               logger.error("backend service start fail!!!");
            }
        }

        public void stop() {
            if(server.isServing()){
                server.setShouldStop(true);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("", e);
                }
            }else{
                server.setShouldStop(true);
            }
            server.stop();
        }
    }
}
