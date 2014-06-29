package com.github.wenhao.http.core.client;

import com.github.wenhao.http.core.model.HttpRequest;
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
                .setConnectTimeout(httpRequest.getTimeout())
                .setSocketTimeout(httpRequest.getTimeout())
                .setConnectionRequestTimeout(httpRequest.getTimeout())
                .build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
    }

}