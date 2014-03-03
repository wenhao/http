package com.github.wenhao.http.method;

import java.util.List;

import static java.lang.String.format;

import com.github.wenhao.http.model.Request;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestFactory
{

    private List<HttpRequestable> httpRequestables;

    public HttpRequestFactory(List<HttpRequestable> httpRequestables)
    {
        this.httpRequestables = httpRequestables;
    }

    public HttpUriRequest create(Request request)
    {
        for (HttpRequestable httpRequestable : httpRequestables) {
            if (httpRequestable.isApplicable(request)) {
                return httpRequestable.apply(request);
            }
        }
        throw new UnsupportedOperationException(format("%s http method not support", request.getHttpMethod().name()));
    }
}
