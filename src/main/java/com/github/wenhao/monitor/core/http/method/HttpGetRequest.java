package com.github.wenhao.monitor.core.http.method;

import java.net.URI;

import com.github.wenhao.monitor.core.http.model.HttpMethod;
import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpGetRequest implements HttpRequestable
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(HttpMethod.GET);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        return new HttpGet(URI.create(httpRequest.getUrl()));
    }
}
