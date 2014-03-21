package com.github.wenhao.monitor.core.http.method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.HttpMethod;
import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.junit.Test;

public class HttpGetHttpRequestTest
{

    @Test
    public void should_be_able_to_get_http_get_request() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setMethod(HttpMethod.GET);


        // when
        HttpGetRequest httpGetRequest = new HttpGetRequest();


        // then
        assertThat(httpGetRequest.isApplicable(httpRequest), is(true));
    }
}
