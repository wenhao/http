package com.github.wenhao.http.client;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

import com.github.wenhao.http.model.Request;
import org.apache.http.impl.client.HttpClientBuilder;

public class HeaderComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(Request request)
    {
        return isNotEmpty(request.getHeaders());
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, Request request)
    {
        httpClientBuilder.setDefaultHeaders(request.getHeaders());
    }
}
