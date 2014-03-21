package com.github.wenhao.monitor.core.dependencies.http;

import com.github.wenhao.monitor.core.http.Http;
import com.github.wenhao.monitor.core.http.client.HeaderComponent;
import com.github.wenhao.monitor.core.http.client.HttpClientComponent;
import com.github.wenhao.monitor.core.http.client.HttpClientFactory;
import com.github.wenhao.monitor.core.http.client.ProxyComponent;
import com.github.wenhao.monitor.core.http.client.TimeoutComponent;
import com.github.wenhao.monitor.core.http.client.UnsafeSSLComponent;
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
