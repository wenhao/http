package com.github.wenhao.http.core.method;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.http.core.model.HttpRequest;

import static com.github.wenhao.http.core.model.HttpMethod.DELETE;

public class HttpDeleteRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return DELETE.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpDelete httpDelete = new HttpDelete(httpRequest.getUrl());
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(httpRequest.getTimeout())
                .setConnectTimeout(httpRequest.getTimeout())
                .build();
        httpDelete.setConfig(requestConfig);
        httpDelete.setHeaders(httpRequest.getHeaders());
        return httpDelete;
    }
}
