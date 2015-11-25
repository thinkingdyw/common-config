package com.thinking.dyw.thrift.rpc.proxy;

public class ServerException extends RuntimeException{


    /**  */
    private static final long serialVersionUID = 1L;

    public ServerException(String msg) {
        super(msg);
    }

    public ServerException(String msg, Throwable e) {
        super(msg, e);
    }
}
