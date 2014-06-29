package com.github.wenhao.http.core.client;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class HeaderComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return isNotEmpty(httpRequest.getHeaders());
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest)
    {
        httpClientBuilder.setDefaultHeaders(httpRequest.getHeaders());
    }
}
