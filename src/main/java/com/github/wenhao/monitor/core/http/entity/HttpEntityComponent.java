package com.github.wenhao.monitor.core.http.entity;

import com.github.wenhao.monitor.core.http.model.Request;
import org.apache.http.HttpEntity;

public interface HttpEntityComponent
{
    Boolean isApplicable(Request request);

    HttpEntity apply(Request request);
}
