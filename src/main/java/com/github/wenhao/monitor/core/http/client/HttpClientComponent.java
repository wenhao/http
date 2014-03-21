package com.github.wenhao.monitor.core.http.client;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public interface HttpClientComponent
{

    Boolean isApplicable(HttpRequest httpRequest);

    void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest);
}
