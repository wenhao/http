package com.github.wenhao.http.method;

import java.net.URI;

import static com.github.wenhao.http.model.HttpMethod.POST;

import com.github.wenhao.http.entity.HttpEntityFactory;
import com.github.wenhao.http.model.Request;
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
    public Boolean isApplicable(Request request)
    {
        return request.getHttpMethod().equals(POST);
    }

    @Override
    public HttpUriRequest apply(Request request)
    {
        HttpPost httpPost = new HttpPost(URI.create(request.getUrl()));
        httpPost.setEntity(httpEntityFactory.create(request));
        return httpPost;
    }
}
