package com.github.wenhao.http.client;

import java.util.List;

import com.github.wenhao.http.model.Request;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientFactory
{

    private List<HttpClientComponent> httpClientComponents;

    public HttpClientFactory(List<HttpClientComponent> httpClientComponents)
    {
        this.httpClientComponents = httpClientComponents;
    }

    public HttpClient create(Request request)
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        for (HttpClientComponent httpClientComponent : httpClientComponents) {
            if (httpClientComponent.isApplicable(request)) {
                httpClientComponent.apply(httpClientBuilder, request);
            }
        }
        return httpClientBuilder.build();
    }
}
