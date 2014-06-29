package com.github.wenhao.http.core.method;

import java.net.URI;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.http.core.model.HttpRequest;


import static com.github.wenhao.http.core.model.HttpMethod.OPTIONS;

public class HttpOptionsRequest implements HttpRequestable
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return OPTIONS.equals(httpRequest.getHttpMethod());
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpOptions httpOptions = new HttpOptions(URI.create(httpRequest.getUrl()));
        for (Header header : httpRequest.getHeaders()) {
            httpOptions.setHeader(header);
        }

        return httpOptions;
    }
}
