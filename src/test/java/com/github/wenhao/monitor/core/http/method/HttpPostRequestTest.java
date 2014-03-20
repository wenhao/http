package com.github.wenhao.monitor.core.http.method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.github.wenhao.monitor.core.http.entity.HttpEntityFactory;
import com.github.wenhao.monitor.core.http.model.HttpMethod;
import com.github.wenhao.monitor.core.http.model.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

public class HttpPostRequestTest
{

    @Test
    public void should_be_able_to_get_http_post_request() throws Exception
    {
        // given
        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        HttpEntityFactory httpEntityFactory = mock(HttpEntityFactory.class);
        given(httpEntityFactory.create(request)).willReturn(new StringEntity("test", ContentType.DEFAULT_TEXT));


        // when
        HttpPostRequest httpPostRequest = new HttpPostRequest(httpEntityFactory);

        // then
        assertThat(httpPostRequest.isApplicable(request), is(true));
    }
}
