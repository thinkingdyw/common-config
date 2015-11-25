package com.thinking.dyw.thrift.rpc.proxy;

public interface Server {
    public static final int DEFAULT_PORT = 9090;
    
    public void start() throws Exception;
    public void stop() throws Exception;
    
    public String getHost();
    public int getPort();
}