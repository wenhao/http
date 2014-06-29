package com.github.wenhao.http.core.model;

public class HttpResponse
{

    private Integer status;
    private String content;

    public HttpResponse(Integer status, String content)
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
