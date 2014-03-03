package com.github.wenhao.http.entity;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.http.entity.ContentType.DEFAULT_TEXT;

import com.github.wenhao.http.model.Request;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

public class BodyEntity implements HttpEntityComponent
{
    @Override
    public Boolean isApplicable(Request request)
    {
        return isNoneBlank(request.getBody());
    }

    @Override
    public HttpEntity apply(Request request)
    {
        return new StringEntity(request.getBody(), DEFAULT_TEXT);
    }
}
