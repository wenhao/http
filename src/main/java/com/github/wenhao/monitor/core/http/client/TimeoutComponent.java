package com.github.wenhao.monitor.core.http.client;

import com.github.wenhao.monitor.core.http.model.Request;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;

public class TimeoutComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(Request request)
    {
        return request.getTimeout() != null;
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, Request request)
    {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(seconds(request.getTimeout()))
                .setSocketTimeout(seconds(request.getTimeout()))
                .setConnectionRequestTimeout(seconds(request.getTimeout()))
                .build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
    }

    private int seconds(Integer timeout)
    {
        return timeout * 1000;
    }
}
