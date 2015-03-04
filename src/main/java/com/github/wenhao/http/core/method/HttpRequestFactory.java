package com.github.wenhao.http.core.method;

import static java.lang.String.format;

import java.util.List;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;

public class HttpRequestFactory
{

    private List<HttpRequestable> httpRequestables;

    public HttpRequestFactory(List<HttpRequestable> httpRequestables)
    {
        this.httpRequestables = httpRequestables;
    }

    public HttpRequestBase create(HttpRequest httpRequest)
    {
        for (HttpRequestable httpRequestable : httpRequestables) {
            if (httpRequestable.isApplicable(httpRequest)) {
                HttpRequestBase httpRequestBase = httpRequestable.apply(httpRequest);
                if (httpRequest.getProxy() != null) {
                    httpRequestBase.setConfig(RequestConfig.custom().setProxy(httpRequest.getProxy()).build());
                }
                return httpRequestBase;
            }
        }
        throw new UnsupportedOperationException(format("%s http method not support", httpRequest.getHttpMethod().name()));
    }
}
