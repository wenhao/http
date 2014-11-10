package com.github.wenhao.http.core.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.core.model.HttpRequest;
import org.junit.Test;

public class ProxyComponentTest
{

    @Test
    public void should_be_able_to_add_proxy() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.proxy("http://localhost", 8080);


        // when
        ProxyComponent proxyComponent = new ProxyComponent();


        // then
        assertThat(proxyComponent.isApplicable(httpRequest), is(true));
    }
}
