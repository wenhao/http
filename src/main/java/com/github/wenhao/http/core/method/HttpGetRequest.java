package com.github.wenhao.http.core.method;

import java.net.URI;

import com.github.wenhao.http.core.model.HttpMethod;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpGetRequest implements HttpRequestable
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(HttpMethod.GET);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpGet httpGet = new HttpGet(URI.create(httpRequest.getUrl()));
        for (Header header : httpRequest.getHeaders()) {
            httpGet.setHeader(header);
        }
        return httpGet;
    }
}
