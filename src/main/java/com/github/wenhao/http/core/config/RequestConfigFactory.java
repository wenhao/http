package com.github.wenhao.http.core.config;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.config.RequestConfig;

public class RequestConfigFactory
{
    public RequestConfig create(HttpRequest httpRequest)
    {
        return RequestConfig.custom()
                .setConnectTimeout(httpRequest.getTimeout())
                .setConnectionRequestTimeout(httpRequest.getTimeout())
                .setSocketTimeout(httpRequest.getTimeout())
                .setProxy(httpRequest.getProxy())
                .build();
    }

}
