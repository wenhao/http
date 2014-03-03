package com.github.wenhao.http.entity;

import java.util.List;

import com.github.wenhao.http.model.Request;
import org.apache.http.HttpEntity;

public class HttpEntityFactory
{

    private List<HttpEntityComponent> httpEntityComponents;

    public HttpEntityFactory(List<HttpEntityComponent> httpEntityComponents)
    {
        this.httpEntityComponents = httpEntityComponents;
    }

    public HttpEntity create(Request request)
    {
        for (HttpEntityComponent httpEntityComponent : httpEntityComponents) {
            if (httpEntityComponent.isApplicable(request)) {
                return httpEntityComponent.apply(request);
            }
        }
        return null;
    }
}
