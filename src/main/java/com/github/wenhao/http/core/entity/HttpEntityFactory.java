package com.github.wenhao.http.core.entity;

import java.util.List;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpEntity;

public class HttpEntityFactory
{

    private List<HttpEntityComponent> httpEntityComponents;

    public HttpEntityFactory(List<HttpEntityComponent> httpEntityComponents)
    {
        this.httpEntityComponents = httpEntityComponents;
    }

    public HttpEntity create(HttpRequest httpRequest)
    {
        for (HttpEntityComponent httpEntityComponent : httpEntityComponents) {
            if (httpEntityComponent.isApplicable(httpRequest)) {
                return httpEntityComponent.apply(httpRequest);
            }
        }
        return null;
    }
}
