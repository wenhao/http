package com.github.wenhao.http.core.method;

import java.net.URI;

import static com.github.wenhao.http.core.model.HttpMethod.POST;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpPostRequest implements HttpRequestable
{

    private HttpEntityFactory httpEntityFactory;
    private RequestConfigFactory requestConfigFactory;

    public HttpPostRequest(HttpEntityFactory httpEntityFactory, RequestConfigFactory requestConfigFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
        this.requestConfigFactory = requestConfigFactory;
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
        httpPost.setConfig(requestConfigFactory.create(httpRequest));
        httpPost.setHeaders(httpRequest.getHeaders());
        return httpPost;
    }
}
