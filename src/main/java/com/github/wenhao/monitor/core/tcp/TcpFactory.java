package com.github.wenhao.monitor.core.tcp;

import static se.jbee.inject.Dependency.dependency;

import com.github.wenhao.monitor.core.dependencies.RootBundle;
import se.jbee.inject.Injector;
import se.jbee.inject.bootstrap.Bootstrap;

public class TcpFactory
{

    public static Tcp create()
    {
        Injector injector = Bootstrap.injector(RootBundle.class);
        return injector.resolve(dependency(Tcp.class));
    }
}
