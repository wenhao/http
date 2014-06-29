package com.github.wenhao.http.core.method;

import java.util.List;

import static java.lang.String.format;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestFactory
{

    private List<HttpRequestable> httpRequestables;

    public HttpRequestFactory(List<HttpRequestable> httpRequestables)
    {
        this.httpRequestables = httpRequestables;
    }

    public HttpUriRequest create(HttpRequest httpRequest)
    {
        for (HttpRequestable httpRequestable : httpRequestables) {
            if (httpRequestable.isApplicable(httpRequest)) {
                return httpRequestable.apply(httpRequest);
            }
        }
        throw new UnsupportedOperationException(format("%s http method not support", httpRequest.getHttpMethod().name()));
    }
}
