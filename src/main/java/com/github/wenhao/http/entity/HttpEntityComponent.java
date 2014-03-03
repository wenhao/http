package com.github.wenhao.http.entity;

import com.github.wenhao.http.model.Request;
import org.apache.http.HttpEntity;

public interface HttpEntityComponent
{
    Boolean isApplicable(Request request);

    HttpEntity apply(Request request);
}
