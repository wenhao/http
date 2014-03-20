package com.github.wenhao.monitor.core.http;

import static se.jbee.inject.Dependency.dependency;

import com.github.wenhao.monitor.core.dependencies.RootBundle;
import se.jbee.inject.Injector;
import se.jbee.inject.bootstrap.Bootstrap;

public class HttpFactory
{

    public static Http create()
    {
        Injector injector = Bootstrap.injector(RootBundle.class);
        return injector.resolve(dependency(Http.class));
    }
}
