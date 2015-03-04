package com.github.wenhao.http.core.method;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.client.methods.HttpRequestBase;

public interface HttpRequestable
{

    Boolean isApplicable(HttpRequest httpRequest);

    HttpRequestBase apply(HttpRequest httpRequest);
}
