package com.github.wenhao.http.core.method;

import java.net.URI;

import static com.github.wenhao.http.core.model.HttpMethod.HEAD;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpHeadRequest implements HttpRequestable
{
    private RequestConfigFactory requestConfigFactory;

    public HttpHeadRequest(RequestConfigFactory requestConfigFactory)
    {
        this.requestConfigFactory = requestConfigFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return HEAD.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpHead httpHead = new HttpHead(URI.create(httpRequest.getUrl()));
        httpHead.setConfig(requestConfigFactory.create(httpRequest));
        httpHead.setHeaders(httpRequest.getHeaders());
        return httpHead;
    }
}
