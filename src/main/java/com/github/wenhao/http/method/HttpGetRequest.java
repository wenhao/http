package com.github.wenhao.http.method;

import java.net.URI;

import com.github.wenhao.http.model.HttpMethod;
import com.github.wenhao.http.model.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpGetRequest implements HttpRequestable
{

    @Override
    public Boolean isApplicable(Request request)
    {
        return request.getHttpMethod().equals(HttpMethod.GET);
    }

    @Override
    public HttpUriRequest apply(Request request)
    {
        return new HttpGet(URI.create(request.getUrl()));
    }
}
