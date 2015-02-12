package com.github.wenhao.http.core.method;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

import static com.github.wenhao.http.core.model.HttpMethod.PUT;

public class HttpPutRequest implements HttpRequestable
{
    private HttpEntityFactory httpEntityFactory;
    private RequestConfigFactory requestConfigFactory;

    public HttpPutRequest(HttpEntityFactory httpEntityFactory, RequestConfigFactory requestConfigFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
        this.requestConfigFactory = requestConfigFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(PUT);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpPut httpPut = new HttpPut();
        httpPut.setEntity(httpEntityFactory.create(httpRequest));
        httpPut.setConfig(requestConfigFactory.create(httpRequest));
        httpPut.setHeaders(httpRequest.getHeaders());
        return httpPut;
    }
}
