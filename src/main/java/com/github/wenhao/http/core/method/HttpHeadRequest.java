package com.github.wenhao.http.core.method;

import java.net.URI;

import static com.github.wenhao.http.core.model.HttpMethod.HEAD;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;

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
        httpHead.setHeaders(httpRequest.getHeaders());
        return httpHead;
    }
}
