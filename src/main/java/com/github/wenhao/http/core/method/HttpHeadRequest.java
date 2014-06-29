package com.github.wenhao.http.core.method;

import java.net.URI;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.http.core.model.HttpRequest;


import static com.github.wenhao.http.core.model.HttpMethod.HEAD;

public class HttpHeadRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return HEAD.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpHead httpHead = new HttpHead(URI.create(httpRequest.getUrl()));
        for (Header header : httpRequest.getHeaders()) {
            httpHead.setHeader(header);
        }

        return httpHead;
    }
}
