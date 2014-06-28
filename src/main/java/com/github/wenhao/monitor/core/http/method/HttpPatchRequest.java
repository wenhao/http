package com.github.wenhao.monitor.core.http.method;

import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpUriRequest;

import com.github.wenhao.monitor.core.http.entity.HttpEntityFactory;
import com.github.wenhao.monitor.core.http.model.HttpRequest;

import static com.github.wenhao.monitor.core.http.model.HttpMethod.PATCH;

public class HttpPatchRequest implements HttpRequestable
{
    private HttpEntityFactory httpEntityFactory;

    public HttpPatchRequest(HttpEntityFactory httpEntityFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
    }

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getHttpMethod().equals(PATCH);
    }

    @Override
    public HttpUriRequest apply(HttpRequest httpRequest)
    {
        HttpPatch httpPatch = new HttpPatch();
        httpPatch.setEntity(httpEntityFactory.create(httpRequest));
        return null;
    }
}
