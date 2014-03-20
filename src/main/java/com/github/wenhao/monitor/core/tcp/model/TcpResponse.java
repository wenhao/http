package com.github.wenhao.monitor.core.tcp.model;

public class TcpResponse
{

    private Status status;
    private String content;

    public TcpResponse(Status status, String content)
    {
        this.status = status;
        this.content = content;
    }

    public Status getStatus()
    {
        return status;
    }

    public String getContent()
    {
        return content;
    }
}
