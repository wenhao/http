package com.github.wenhao.monitor.core.http.method;

import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.monitor.core.http.model.HttpRequest;

import static com.github.wenhao.monitor.core.http.model.HttpMethod.HEAD;

public class HttpHeadRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return HEAD.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        return new HttpHead(httpRequest.getUrl());
    }
}
