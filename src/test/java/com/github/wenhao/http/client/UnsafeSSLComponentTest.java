package com.github.wenhao.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.model.Request;
import org.junit.Test;

public class UnsafeSSLComponentTest
{

    @Test
    public void should_be_able_to_trust_all_ssl() throws Exception
    {
        // given
        Request request = new Request();
        request.setUrl("https://localhost");

        // when
        UnsafeSSLComponent unsafeSSLComponent = new UnsafeSSLComponent();

        // then
        assertThat(unsafeSSLComponent.isApplicable(request), is(true));
    }
}
