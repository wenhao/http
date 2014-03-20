package com.github.wenhao.monitor.core.dependencies;

import com.github.wenhao.monitor.core.http.Http;
import com.github.wenhao.monitor.core.http.client.HeaderComponent;
import com.github.wenhao.monitor.core.http.client.HttpClientComponent;
import com.github.wenhao.monitor.core.http.client.HttpClientFactory;
import com.github.wenhao.monitor.core.http.client.ProxyComponent;
import com.github.wenhao.monitor.core.http.client.TimeoutComponent;
import com.github.wenhao.monitor.core.http.client.UnsafeSSLComponent;
import com.github.wenhao.monitor.core.http.entity.BodyEntity;
import com.github.wenhao.monitor.core.http.entity.HttpEntityComponent;
import com.github.wenhao.monitor.core.http.entity.HttpEntityFactory;
import com.github.wenhao.monitor.core.http.entity.ParameterEntity;
import com.github.wenhao.monitor.core.http.method.HttpGetRequest;
import com.github.wenhao.monitor.core.http.method.HttpPostRequest;
import com.github.wenhao.monitor.core.http.method.HttpRequestFactory;
import com.github.wenhao.monitor.core.http.method.HttpRequestable;
import se.jbee.inject.bind.BinderModule;

public class HttpModule extends BinderModule
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

        construct(BodyEntity.class);
        construct(ParameterEntity.class);
        multibind(HttpEntityComponent.class).to(BodyEntity.class);
        multibind(HttpEntityComponent.class).to(ParameterEntity.class);
        construct(HttpEntityFactory.class);

        construct(HttpGetRequest.class);
        construct(HttpPostRequest.class);
        multibind(HttpRequestable.class).to(HttpGetRequest.class);
        multibind(HttpRequestable.class).to(HttpPostRequest.class);
        construct(HttpRequestFactory.class);
    }
}
