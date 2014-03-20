package com.github.wenhao.monitor.core.http.method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.HttpMethod;
import com.github.wenhao.monitor.core.http.model.Request;
import org.junit.Test;

public class HttpGetRequestTest
{

    @Test
    public void should_be_able_to_get_http_get_request() throws Exception
    {
        // given
        Request request = new Request();
        request.setMethod(HttpMethod.GET);


        // when
        HttpGetRequest httpGetRequest = new HttpGetRequest();


        // then
        assertThat(httpGetRequest.isApplicable(request), is(true));
    }
}
