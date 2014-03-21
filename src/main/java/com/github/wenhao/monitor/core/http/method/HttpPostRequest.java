package com.github.wenhao.monitor.core.http.method;

import java.net.URI;

import static com.github.wenhao.monitor.core.http.model.HttpMethod.POST;

import com.github.wenhao.monitor.core.http.entity.HttpEntityFactory;
import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

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
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpPost httpPost = new HttpPost(URI.create(httpRequest.getUrl()));
        httpPost.setEntity(httpEntityFactory.create(httpRequest));
        return httpPost;
    }
}
