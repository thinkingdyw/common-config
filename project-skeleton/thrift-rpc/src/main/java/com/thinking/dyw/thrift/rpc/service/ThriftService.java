package com.thinking.dyw.thrift.rpc.service;

/**
 * @author thinkingdyw
 * @version $Id: ThriftService.java, v 0.1 2015年11月12日 下午3:41:56 thinkingdyw Exp $
 */
public interface ThriftService {

    public void init();
    public String getGroup();
    public void setGroup(String groupName);
    public String getHost();
    public void setHost();
    public int getPort();
    public void setPort();
}
