package com.github.wenhao.http.core.config;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

import static org.apache.http.client.config.RequestConfig.DEFAULT;

public class RequestConfigFactory
{
    public RequestConfig create(HttpRequest httpRequest)
    {
        return null;
    }

    private RequestConfig setTimeout(RequestConfig requestConfig, int timeout)
    {
        if (timeout > 0) {
            return RequestConfig.custom()
                    .setSocketTimeout(timeout)
                    .setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout)
                    .build();
        }
        return DEFAULT;
    }

    private RequestConfig setProxy(RequestConfig requestConfig, HttpHost proxy)
    {
        if (proxy != null) {
            return RequestConfig.custom()
                    .setProxy(proxy)
                    .build();
        }
        return DEFAULT;
    }
}
