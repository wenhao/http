package com.github.wenhao.http.core.entity;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpEntity;

public interface HttpEntityComponent
{
    Boolean isApplicable(HttpRequest httpRequest);

    HttpEntity apply(HttpRequest httpRequest);
}
