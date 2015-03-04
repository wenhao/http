package com.github.wenhao.http.core.method;

import java.net.URI;

import static com.github.wenhao.http.core.model.HttpMethod.OPTIONS;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpUriRequest;

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
        httpOptions.setHeaders(httpRequest.getHeaders());
        return httpOptions;
    }
}
