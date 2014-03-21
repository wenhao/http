package com.github.wenhao.monitor.core.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.junit.Test;

public class HeaderComponentTest
{

    @Test
    public void should_be_able_to_set_default_headers() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.addHeader("test", "test");


        // when
        HeaderComponent headerComponent = new HeaderComponent();


        // then
        assertThat(headerComponent.isApplicable(httpRequest), is(true));
    }
}
