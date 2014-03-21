package com.github.wenhao.monitor.core.dependencies.http;

import com.github.wenhao.monitor.core.http.method.HttpGetRequest;
import com.github.wenhao.monitor.core.http.method.HttpPostRequest;
import com.github.wenhao.monitor.core.http.method.HttpRequestFactory;
import com.github.wenhao.monitor.core.http.method.HttpRequestable;
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
