package com.github.wenhao.http.core.entity;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.http.Consts.UTF_8;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class ParameterEntity implements HttpEntityComponent
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return isNotEmpty(httpRequest.getParameters());
    }

    @Override
    public HttpEntity apply(HttpRequest httpRequest)
    {
        return new UrlEncodedFormEntity(httpRequest.getParameters(), UTF_8);
    }
}
