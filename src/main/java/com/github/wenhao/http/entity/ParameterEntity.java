package com.github.wenhao.http.entity;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.http.Consts.UTF_8;

import com.github.wenhao.http.model.Request;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class ParameterEntity implements HttpEntityComponent
{

    @Override
    public Boolean isApplicable(Request request)
    {
        return isNotEmpty(request.getParameters());
    }

    @Override
    public HttpEntity apply(Request request)
    {
        return new UrlEncodedFormEntity(request.getParameters(), UTF_8);
    }
}
