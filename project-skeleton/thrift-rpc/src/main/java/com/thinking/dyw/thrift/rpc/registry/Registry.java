package com.thinking.dyw.thrift.rpc.registry;

import com.thinking.dyw.thrift.rpc.service.ThriftService;

public interface Registry {

    public void registry(ThriftService service) throws ServiceRegisterException;
}