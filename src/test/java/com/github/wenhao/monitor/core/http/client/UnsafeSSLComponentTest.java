package com.github.wenhao.monitor.core.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.junit.Test;

public class UnsafeSSLComponentTest
{

    @Test
    public void should_be_able_to_trust_all_ssl() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setUrl("https://localhost");

        // when
        UnsafeSSLComponent unsafeSSLComponent = new UnsafeSSLComponent();

        // then
        assertThat(unsafeSSLComponent.isApplicable(httpRequest), is(true));
    }
}
