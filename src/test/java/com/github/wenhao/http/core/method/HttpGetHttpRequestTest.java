package com.github.wenhao.http.core.method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.core.model.HttpMethod;
import com.github.wenhao.http.core.model.HttpRequest;
import org.junit.Test;

public class HttpGetHttpRequestTest
{

    @Test
    public void should_be_able_to_get_http_get_request() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.method(HttpMethod.GET);

        // when
        HttpGetRequest httpGetRequest = new HttpGetRequest();


        // then
        assertThat(httpGetRequest.isApplicable(httpRequest), is(true));
    }
}
