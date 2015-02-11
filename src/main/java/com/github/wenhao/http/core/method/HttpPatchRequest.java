package com.github.wenhao.http.core.method;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;

import static com.github.wenhao.http.core.model.HttpMethod.PATCH;

public class HttpPatchRequest implements HttpRequestable
{
    private HttpEntityFactory httpEntityFactory;

    public HttpPatchRequest(HttpEntityFactory httpEntityFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(PATCH);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpPatch httpPatch = new HttpPatch();
        httpPatch.setEntity(httpEntityFactory.create(httpRequest));
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(httpRequest.getTimeout())
                .setConnectTimeout(httpRequest.getTimeout())
                .build();
        httpPatch.setConfig(requestConfig);
        httpPatch.setHeaders(httpRequest.getHeaders());
        return httpPatch;
    }
}
