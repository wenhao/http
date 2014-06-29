package com.github.wenhao.http.core.entity;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import static org.apache.http.Consts.UTF_8;

public class ParameterEntity implements HttpEntityComponent
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return !httpRequest.getParameters().isEmpty();
    }

    @Override
    public HttpEntity apply(HttpRequest httpRequest)
    {
        return new UrlEncodedFormEntity(httpRequest.getParameters(), UTF_8);
    }
}
