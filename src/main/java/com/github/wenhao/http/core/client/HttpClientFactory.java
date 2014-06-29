package com.github.wenhao.http.core.client;

import java.util.List;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientFactory
{

    private List<HttpClientComponent> httpClientComponents;

    public HttpClientFactory(List<HttpClientComponent> httpClientComponents)
    {
        this.httpClientComponents = httpClientComponents;
    }

    public HttpClient create(HttpRequest httpRequest)
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        for (HttpClientComponent httpClientComponent : httpClientComponents) {
            if (httpClientComponent.isApplicable(httpRequest)) {
                httpClientComponent.apply(httpClientBuilder, httpRequest);
            }
        }
        return httpClientBuilder.build();
    }
}
