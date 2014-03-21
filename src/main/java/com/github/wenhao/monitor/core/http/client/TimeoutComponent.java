package com.github.wenhao.monitor.core.http.client;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;

public class TimeoutComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getTimeout() != null;
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest)
    {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(seconds(httpRequest.getTimeout()))
                .setSocketTimeout(seconds(httpRequest.getTimeout()))
                .setConnectionRequestTimeout(seconds(httpRequest.getTimeout()))
                .build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
    }

    private int seconds(Integer timeout)
    {
        return timeout * 1000;
    }
}
