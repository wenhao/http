package com.github.wenhao.http.core.method;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;

import static com.github.wenhao.http.core.model.HttpMethod.DELETE;

public class HttpDeleteRequest implements HttpRequestable
{
    private RequestConfigFactory requestConfigFactory;

    public HttpDeleteRequest(RequestConfigFactory requestConfigFactory)
    {
        this.requestConfigFactory = requestConfigFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return DELETE.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpDelete httpDelete = new HttpDelete(httpRequest.getUrl());
        httpDelete.setConfig(requestConfigFactory.create(httpRequest));
        httpDelete.setHeaders(httpRequest.getHeaders());
        return httpDelete;
    }
}
