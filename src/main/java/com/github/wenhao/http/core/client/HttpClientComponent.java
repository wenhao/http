package com.github.wenhao.http.core.client;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public interface HttpClientComponent
{

    Boolean isApplicable(HttpRequest httpRequest);

    void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest);
}
