package com.github.wenhao.monitor.core.dependencies;

import se.jbee.inject.bind.BuildinBundle;
import se.jbee.inject.bootstrap.BootstrapperBundle;

public class RootBundle extends BootstrapperBundle
{

    @Override
    protected void bootstrap()
    {
        install(HttpModule.class);
        install(TcpModule.class);
        install(BuildinBundle.LIST);
    }
}
