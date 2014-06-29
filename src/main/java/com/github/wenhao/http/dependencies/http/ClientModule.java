package com.github.wenhao.http.dependencies.http;

import com.github.wenhao.http.core.Http;
import com.github.wenhao.http.core.client.HeaderComponent;
import com.github.wenhao.http.core.client.HttpClientComponent;
import com.github.wenhao.http.core.client.HttpClientFactory;
import com.github.wenhao.http.core.client.ProxyComponent;
import com.github.wenhao.http.core.client.TimeoutComponent;
import com.github.wenhao.http.core.client.UnsafeSSLComponent;
import se.jbee.inject.bind.BinderModule;

public class ClientModule extends BinderModule
{

    @Override
    protected void declare()
    {
        construct(HeaderComponent.class);
        construct(ProxyComponent.class);
        construct(UnsafeSSLComponent.class);
        construct(TimeoutComponent.class);
        multibind(HttpClientComponent.class).to(HeaderComponent.class);
        multibind(HttpClientComponent.class).to(ProxyComponent.class);
        multibind(HttpClientComponent.class).to(UnsafeSSLComponent.class);
        multibind(HttpClientComponent.class).to(TimeoutComponent.class);
        construct(HttpClientFactory.class);
        construct(Http.class);
    }
}
