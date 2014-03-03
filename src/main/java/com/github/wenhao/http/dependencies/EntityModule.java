package com.github.wenhao.http.dependencies;

import com.github.wenhao.http.entity.BodyEntity;
import com.github.wenhao.http.entity.HttpEntityComponent;
import com.github.wenhao.http.entity.HttpEntityFactory;
import com.github.wenhao.http.entity.ParameterEntity;
import se.jbee.inject.bind.BinderModule;

public class EntityModule extends BinderModule
{

    @Override
    protected void declare()
    {
        construct(BodyEntity.class);
        construct(ParameterEntity.class);
        multibind(HttpEntityComponent.class).to(BodyEntity.class);
        multibind(HttpEntityComponent.class).to(ParameterEntity.class);
        construct(HttpEntityFactory.class);
    }
}
