package com.github.wenhao.http.core.method;

import static org.apache.http.client.config.RequestConfig.DEFAULT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.wenhao.http.core.config.RequestConfigFactory;
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
        RequestConfigFactory requestConfigFactory = mock(RequestConfigFactory.class);
        when(requestConfigFactory.create(httpRequest)).thenReturn(DEFAULT);

        // when
        HttpGetRequest httpGetRequest = new HttpGetRequest(requestConfigFactory);


        // then
        assertThat(httpGetRequest.isApplicable(httpRequest), is(true));
    }
}
