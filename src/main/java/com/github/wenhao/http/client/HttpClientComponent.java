package com.github.wenhao.http.client;

import com.github.wenhao.http.model.Request;
import org.apache.http.impl.client.HttpClientBuilder;

public interface HttpClientComponent
{

    Boolean isApplicable(Request request);

    void apply(HttpClientBuilder httpClientBuilder, Request request);
}
