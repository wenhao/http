package com.github.wenhao.http.core.method;

import static com.github.wenhao.http.core.model.HttpMethod.DELETE;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;

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
        httpDelete.setHeaders(httpRequest.getHeaders());
        return httpDelete;
    }
}
