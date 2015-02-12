package com.github.wenhao.http.core.method;

import static org.apache.http.client.config.RequestConfig.DEFAULT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.wenhao.http.core.config.RequestConfigFactory;
import com.github.wenhao.http.core.entity.HttpEntityFactory;
import com.github.wenhao.http.core.model.HttpMethod;
import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

public class HttpPostHttpRequestTest
{

    @Test
    public void should_be_able_to_get_http_post_request() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.method(HttpMethod.POST);
        HttpEntityFactory httpEntityFactory = mock(HttpEntityFactory.class);
        given(httpEntityFactory.create(httpRequest)).willReturn(new StringEntity("test", ContentType.DEFAULT_TEXT));
        RequestConfigFactory requestConfigFactory = mock(RequestConfigFactory.class);
        when(requestConfigFactory.create(httpRequest)).thenReturn(DEFAULT);


        // when
        HttpPostRequest httpPostRequest = new HttpPostRequest(httpEntityFactory, requestConfigFactory);

        // then
        assertThat(httpPostRequest.isApplicable(httpRequest), is(true));
    }
}
