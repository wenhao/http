package com.github.wenhao.monitor.core.http.method;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.monitor.core.http.model.HttpRequest;

import static com.github.wenhao.monitor.core.http.model.HttpMethod.DELETE;

public class HttpDeleteRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return DELETE.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        return new HttpDelete(httpRequest.getUrl());
    }
}
