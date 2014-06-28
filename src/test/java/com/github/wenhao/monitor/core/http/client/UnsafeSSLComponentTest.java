package com.github.wenhao.monitor.core.http.client;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
        httpRequest.trustAll(true);

        // when
        UnsafeSSLComponent unsafeSSLComponent = new UnsafeSSLComponent();

        // then
        assertThat(unsafeSSLComponent.isApplicable(httpRequest), is(false));
    }
}
