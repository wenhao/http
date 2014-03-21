package com.github.wenhao.monitor.core.http.method;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public interface HttpRequestable
{

    Boolean isApplicable(HttpRequest httpRequest);

    HttpUriRequest apply(HttpRequest httpRequest);
}
