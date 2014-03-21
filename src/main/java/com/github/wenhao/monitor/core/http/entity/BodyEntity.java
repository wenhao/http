package com.github.wenhao.monitor.core.http.entity;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.http.entity.ContentType.DEFAULT_TEXT;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class BodyEntity implements HttpEntityComponent
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return isNoneBlank(httpRequest.getBody());
    }

    @Override
    public HttpEntity apply(HttpRequest httpRequest)
    {
        return new StringEntity(httpRequest.getBody(), DEFAULT_TEXT);
    }
}
