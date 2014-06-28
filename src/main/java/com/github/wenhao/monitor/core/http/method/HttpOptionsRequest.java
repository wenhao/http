package com.github.wenhao.monitor.core.http.method;

import java.net.URI;

import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.monitor.core.http.model.HttpRequest;


import static com.github.wenhao.monitor.core.http.model.HttpMethod.OPTIONS;

public class HttpOptionsRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return OPTIONS.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        return new HttpOptions(URI.create(httpRequest.getUrl()));
    }
}
