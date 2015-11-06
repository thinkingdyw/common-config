package com.thinking.dyw.backend.service.impl;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thinking.dyw.backend.service.ThriftBackEndService.Iface;
import com.thinking.dyw.backend.service.ThriftResult;

public class ThriftBackendServiceImpl implements Iface{

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public ThriftResult request(String value) throws TException {
        logger.info("accept paramerters:"+value);
        ThriftResult result = new ThriftResult();
        
        return result;
    }

    @Override
    public void oneWayRequest(String value) throws TException {
        
    }

}
