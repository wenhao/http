package com.github.wenhao.http.core.method;

import java.net.URI;

import static com.github.wenhao.http.core.model.HttpMethod.POST;

import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

public class HttpPostRequest implements HttpRequestable
{

    private HttpEntityFactory httpEntityFactory;

    public HttpPostRequest(HttpEntityFactory httpEntityFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(POST);
    }

    @Override
    public HttpRequestBase apply(HttpRequest httpRequest)
    {
        HttpPost httpPost = new HttpPost(URI.create(httpRequest.getUrl()));
        httpPost.setEntity(httpEntityFactory.create(httpRequest));
        httpPost.setHeaders(httpRequest.getHeaders());
        return httpPost;
    }
}
