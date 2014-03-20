package com.github.wenhao.monitor.core.http.method;

import com.github.wenhao.monitor.core.http.model.Request;
import org.apache.http.client.methods.HttpUriRequest;

public interface HttpRequestable
{

    Boolean isApplicable(Request request);

    HttpUriRequest apply(Request request);
}
