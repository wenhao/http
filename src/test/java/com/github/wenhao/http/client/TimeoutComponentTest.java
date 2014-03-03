package com.github.wenhao.http.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.model.Request;
import org.junit.Test;

public class TimeoutComponentTest
{

    @Test
    public void should_be_able_to_add_timeout() throws Exception
    {
        // given
        Request request = new Request();
        request.setTimeout(50);


        // when
        TimeoutComponent timeoutComponent = new TimeoutComponent();

        // then
        assertThat(timeoutComponent.isApplicable(request), is(true));
    }
}
