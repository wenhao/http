package com.github.wenhao.monitor.core.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.junit.Test;

public class ProxyComponentTest
{

    @Test
    public void should_be_able_to_add_proxy() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setProxy("http://localhost", 8080);


        // when
        ProxyComponent proxyComponent = new ProxyComponent();


        // then
        assertThat(proxyComponent.isApplicable(httpRequest), is(true));
    }
}
