package com.github.wenhao.monitor.core.http.model;

public class Response
{

    private Integer status;
    private String content;

    public Response(Integer status, String content)
    {
        this.status = status;
        this.content = content;
    }

    public Integer getStatus()
    {
        return status;
    }

    public String getContent()
    {
        return content;
    }

}
