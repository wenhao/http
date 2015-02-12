package com.github.wenhao.http.core.method;

import java.net.URI;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.model.HttpMethod;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpGetRequest implements HttpRequestable
{
    private RequestConfigFactory requestConfigFactory;

    public HttpGetRequest(RequestConfigFactory requestConfigFactory)
    {
        this.requestConfigFactory = requestConfigFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(HttpMethod.GET);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpGet httpGet = new HttpGet(URI.create(httpRequest.getUrl()));
        httpGet.setConfig(requestConfigFactory.create(httpRequest));
        httpGet.setHeaders(httpRequest.getHeaders());
        return httpGet;
    }
}
