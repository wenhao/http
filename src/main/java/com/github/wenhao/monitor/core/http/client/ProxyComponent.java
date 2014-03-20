package com.github.wenhao.monitor.core.http.client;

import com.github.wenhao.monitor.core.http.model.Request;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProxyComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(Request request)
    {
        return request.getProxy() != null;
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, Request request)
    {
        httpClientBuilder.setProxy(request.getProxy());
    }
}
