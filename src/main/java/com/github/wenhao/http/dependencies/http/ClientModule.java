package com.github.wenhao.http.dependencies.http;

import com.github.wenhao.http.core.Http;
import com.github.wenhao.http.core.client.HttpClientFactory;
import com.github.wenhao.http.core.config.ClasspathConfigurationSourceProvider;
import com.github.wenhao.http.core.config.ConfigurationSourceProvider;
import se.jbee.inject.bind.BinderModule;

public class ClientModule extends BinderModule
{

    @Override
    protected void declare()
    {
        bind(ConfigurationSourceProvider.class).toConstructor(ClasspathConfigurationSourceProvider.class);
        construct(HttpClientFactory.class);
        construct(Http.class);
    }
}
