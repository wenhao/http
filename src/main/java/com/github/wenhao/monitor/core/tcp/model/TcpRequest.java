package com.github.wenhao.monitor.core.tcp.model;

public class TcpRequest
{

    private String host;
    private Integer port;
    private Integer timeout = 0;

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getHost()
    {
        return host;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }

    public Integer getPort()
    {
        return port;
    }

    public Integer getTimeout()
    {
        return timeout;
    }
}
