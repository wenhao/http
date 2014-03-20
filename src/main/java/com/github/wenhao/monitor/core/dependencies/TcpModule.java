package com.github.wenhao.monitor.core.dependencies;

import com.github.wenhao.monitor.core.tcp.Tcp;
import org.apache.commons.net.echo.EchoTCPClient;
import se.jbee.inject.bind.BinderModule;

public class TcpModule extends BinderModule
{

    @Override
    protected void declare()
    {
        construct(EchoTCPClient.class);
        construct(Tcp.class);
    }
}
