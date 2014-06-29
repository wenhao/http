package com.github.wenhao.http.core.entity;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import static org.apache.http.entity.ContentType.DEFAULT_TEXT;

public class BodyEntity implements HttpEntityComponent
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getBody() != null && !httpRequest.getBody().equals("");
    }

    @Override
    public HttpEntity apply(HttpRequest httpRequest)
    {
        return new StringEntity(httpRequest.getBody(), DEFAULT_TEXT);
    }
}
