package com.github.wenhao.http.dependencies.http;

import com.github.wenhao.http.core.Http;
import com.github.wenhao.http.core.client.HttpClientFactory;
import se.jbee.inject.bind.BinderModule;

public class ClientModule extends BinderModule
{

    @Override
    protected void declare()
    {
        construct(HttpClientFactory.class);
        construct(Http.class);
    }
}
