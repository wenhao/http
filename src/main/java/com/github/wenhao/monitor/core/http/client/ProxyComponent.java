package com.github.wenhao.monitor.core.http.client;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProxyComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getProxy() != null;
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest)
    {
        httpClientBuilder.setProxy(httpRequest.getProxy());
    }
}
