package com.github.wenhao.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.model.Request;
import org.junit.Test;

public class HeaderComponentTest
{

    @Test
    public void should_be_able_to_set_default_headers() throws Exception
    {
        // given
        Request request = new Request();
        request.addHeader("test", "test");


        // when
        HeaderComponent headerComponent = new HeaderComponent();


        // then
        assertThat(headerComponent.isApplicable(request), is(true));
    }
}
