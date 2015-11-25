package com.thinking.dyw.thrift.rpc.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.server.TThreadedSelectorServer.Args;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.thinking.dyw.thrift.rpc.service.ThriftService;

public class TServer implements Server{

    private List<ThriftService> services = new ArrayList<>();
    
    private AtomicBoolean inited = new AtomicBoolean(false);
    private static AtomicBoolean started = new AtomicBoolean(false);
    private TServerTransport serverTransport = null;
    private org.apache.thrift.server.TServer server = null;
    private int port = DEFAULT_PORT;
    
    public TServer(int port) {
        if(started.get()){
            throw new ServerException("server has started!port:"+getPort());
        }
        if(port>65535 || port<=0){
            throw new ServerException("port must be between 1 and 65535");
        }
        this.port = port;
    }
    public TServer() {
        this(DEFAULT_PORT);
    }
    @Override
    public void start() throws Exception {
        init();
        server = instanceServer(); 
        server.serve();
    }

    private org.apache.thrift.server.TServer instanceServer() {
        TNonblockingServerSocket transport = null;
        try {
            transport = new TNonblockingServerSocket(getPort());
        } catch (TTransportException e) {
            throw new ServerException("TServer transport init fail!",e);
        } 
        TThreadedSelectorServer.Args args = new Args(transport);
        
        return new TThreadedSelectorServer(args);
    }
    private void init() {
        if(!inited.compareAndSet(false, true)){
            throw new ServerException("server has inited!");
        }
        try {
            serverTransport = new TServerSocket(9090);
        } catch (TTransportException e) {
            throw new ServerException("server transport init fail!",e);
        }
        for (ThriftService service : services) {
            service.init();
        }
    }
    @Override
    public void stop() throws Exception {
        //TODO
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public int getPort() {
        return port;
    }
}
