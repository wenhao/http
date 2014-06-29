package com.github.wenhao.http.core.method;

import org.apache.http.Header;
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
        for (Header header : httpRequest.getHeaders()) {
            httpDelete.setHeader(header);
        }

        return httpDelete;
    }
}
