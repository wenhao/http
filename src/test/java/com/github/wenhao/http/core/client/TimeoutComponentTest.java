package com.github.wenhao.http.core.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.core.model.HttpRequest;
import org.junit.Test;

public class TimeoutComponentTest
{

    @Test
    public void should_be_able_to_add_timeout() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.timeout(50);


        // when
        TimeoutComponent timeoutComponent = new TimeoutComponent();

        // then
        assertThat(timeoutComponent.isApplicable(httpRequest), is(true));
    }
}
