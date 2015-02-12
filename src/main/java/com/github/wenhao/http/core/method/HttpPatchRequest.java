package com.github.wenhao.http.core.method;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpUriRequest;

import static com.github.wenhao.http.core.model.HttpMethod.PATCH;

public class HttpPatchRequest implements HttpRequestable
{
    private HttpEntityFactory httpEntityFactory;
    private RequestConfigFactory requestConfigFactory;

    public HttpPatchRequest(HttpEntityFactory httpEntityFactory, RequestConfigFactory requestConfigFactory)
    {
        this.httpEntityFactory = httpEntityFactory;
        this.requestConfigFactory = requestConfigFactory;
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
        httpPatch.setConfig(requestConfigFactory.create(httpRequest));
        httpPatch.setHeaders(httpRequest.getHeaders());
        return httpPatch;
    }
}
