package com.github.wenhao.monitor.core.http.entity;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.HttpEntity;

public interface HttpEntityComponent
{
    Boolean isApplicable(HttpRequest httpRequest);

    HttpEntity apply(HttpRequest httpRequest);
}
