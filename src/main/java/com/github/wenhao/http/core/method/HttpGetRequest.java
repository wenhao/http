package com.github.wenhao.http.core.method;

import java.net.URI;

import com.github.wenhao.http.core.model.HttpMethod;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

public class HttpGetRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(HttpMethod.GET);
    }

    @Override
    public HttpRequestBase apply(HttpRequest httpRequest)
    {
        HttpGet httpGet = new HttpGet(URI.create(httpRequest.getUrl()));
        httpGet.setHeaders(httpRequest.getHeaders());
        return httpGet;
    }
}
