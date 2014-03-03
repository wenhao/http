package com.github.wenhao.http.dependencies;

import com.github.wenhao.http.method.HttpGetRequest;
import com.github.wenhao.http.method.HttpPostRequest;
import com.github.wenhao.http.method.HttpRequestFactory;
import com.github.wenhao.http.method.HttpRequestable;
import se.jbee.inject.bind.BinderModule;

public class RequestModule extends BinderModule
{

    @Override
    protected void declare()
    {
        construct(HttpGetRequest.class);
        construct(HttpPostRequest.class);
        multibind(HttpRequestable.class).to(HttpGetRequest.class);
        multibind(HttpRequestable.class).to(HttpPostRequest.class);
        construct(HttpRequestFactory.class);
    }
}
