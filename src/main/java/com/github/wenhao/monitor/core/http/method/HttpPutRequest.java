package com.github.wenhao.monitor.core.http.method;

import com.github.wenhao.monitor.core.http.entity.HttpEntityFactory;
import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

import static com.github.wenhao.monitor.core.http.model.HttpMethod.PUT;

public class HttpPutRequest implements HttpRequestable
{
    private HttpEntityFactory httpEntityFactory;

    public HttpPutRequest(HttpEntityFactory httpEntityFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
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
        return null;
    }
}
