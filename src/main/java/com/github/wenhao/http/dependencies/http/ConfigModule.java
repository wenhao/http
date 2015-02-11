package com.github.wenhao.http.dependencies.http;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import se.jbee.inject.bind.BinderModule;

public class ConfigModule  extends BinderModule
{
    @Override
    protected void declare()
    {
        construct(RequestConfigFactory.class);
    }
}
