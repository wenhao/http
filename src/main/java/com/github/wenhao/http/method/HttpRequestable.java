package com.github.wenhao.http.method;

import com.github.wenhao.http.model.Request;
import org.apache.http.client.methods.HttpUriRequest;

public interface HttpRequestable
{

    Boolean isApplicable(Request request);

    HttpUriRequest apply(Request request);
}
