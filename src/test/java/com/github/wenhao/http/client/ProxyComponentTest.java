package com.github.wenhao.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.model.Request;
import org.junit.Test;

public class ProxyComponentTest
{

    @Test
    public void should_be_able_to_add_proxy() throws Exception
    {
        // given
        Request request = new Request();
        request.setProxy("http://localhost", 8080);


        // when
        ProxyComponent proxyComponent = new ProxyComponent();


        // then
        assertThat(proxyComponent.isApplicable(request), is(true));
    }
}
