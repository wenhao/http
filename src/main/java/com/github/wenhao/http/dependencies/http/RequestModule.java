package com.github.wenhao.http.dependencies.http;

import com.github.wenhao.http.core.method.HttpDeleteRequest;
import com.github.wenhao.http.core.method.HttpGetRequest;
import com.github.wenhao.http.core.method.HttpHeadRequest;
import com.github.wenhao.http.core.method.HttpOptionsRequest;
import com.github.wenhao.http.core.method.HttpPatchRequest;
import com.github.wenhao.http.core.method.HttpPostRequest;
import com.github.wenhao.http.core.method.HttpPutRequest;
import com.github.wenhao.http.core.method.HttpRequestFactory;
import com.github.wenhao.http.core.method.HttpRequestable;
import se.jbee.inject.bind.BinderModule;

public class RequestModule extends BinderModule
{

    @Override
    protected void declare()
    {
        construct(HttpGetRequest.class);
        construct(HttpPostRequest.class);
        construct(HttpPutRequest.class);
        construct(HttpPatchRequest.class);
        construct(HttpOptionsRequest.class);
        construct(HttpDeleteRequest.class);
        construct(HttpHeadRequest.class);
        multibind(HttpRequestable.class).to(HttpGetRequest.class);
        multibind(HttpRequestable.class).to(HttpPostRequest.class);
        multibind(HttpRequestable.class).to(HttpPutRequest.class);
        multibind(HttpRequestable.class).to(HttpPatchRequest.class);
        multibind(HttpRequestable.class).to(HttpOptionsRequest.class);
        multibind(HttpRequestable.class).to(HttpDeleteRequest.class);
        multibind(HttpRequestable.class).to(HttpHeadRequest.class);
        construct(HttpRequestFactory.class);
    }
}
