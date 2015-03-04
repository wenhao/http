package com.github.wenhao.http.core.method;

import static com.github.wenhao.http.core.model.HttpMethod.PATCH;

import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpUriRequest;

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
        httpPatch.setHeaders(httpRequest.getHeaders());
        return httpPatch;
    }
}
