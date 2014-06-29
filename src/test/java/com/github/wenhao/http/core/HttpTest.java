package com.github.wenhao.http.core;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.by;
import static com.github.dreamhead.moco.Moco.eq;
import static com.github.dreamhead.moco.Moco.form;
import static com.github.dreamhead.moco.Moco.header;
import static com.github.dreamhead.moco.Moco.httpserver;
import static com.github.dreamhead.moco.Runner.running;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runnable;
import com.github.wenhao.http.core.client.HttpClientFactory;
import com.github.wenhao.http.core.method.HttpRequestFactory;
import com.github.wenhao.http.core.model.HttpMethod;
import com.github.wenhao.http.core.model.HttpRequest;
import com.github.wenhao.http.core.model.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Before;
import org.junit.Test;

public class HttpTest
{

    private static final String HOST = "http://localhost:9999";
    private HttpServer httpserver;
    private Http http;
    private HttpRequest httpRequest;
    private HttpServer httpServerWithHeader;
    private HttpServer httpServerWithParameter;
    private HttpServer httpServerWithBody;

    @Before
    public void setUp() throws Exception
    {
        httpserver = httpserver(9999);
        httpserver.response("test");
        httpServerWithHeader = httpserver(9999);
        httpServerWithParameter = httpserver(9999);
        httpServerWithBody = httpserver(9999);

        http = HttpFactory.create();
        httpRequest = new HttpRequest();
    }

    @Test
    public void should_be_able_to_get_response_via_get_method() throws Exception
    {
        running(httpserver, new java.lang.Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                httpRequest.setUrl(HOST);
                httpRequest.setMethod(HttpMethod.GET);
                HttpResponse httpResponse = http.send(httpRequest);

                // then
                expectResult(httpResponse, 200, "test");
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_method() throws Exception
    {
        running(httpserver, new java.lang.Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                httpRequest.setUrl(HOST);
                httpRequest.setMethod(HttpMethod.POST);
                HttpResponse httpResponse = http.send(httpRequest);

                // then
                expectResult(httpResponse, 200, "test");
            }
        });
    }


    @Test
    public void should_be_able_to_get_response_via_post_when_basic_auth_require() throws Exception
    {

        // given
        httpServerWithHeader.request(eq(header("Authorization"), "Basic dGVzdDp0ZXN0")).response("test");

        running(httpServerWithHeader, new java.lang.Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                httpRequest.setUrl(HOST);
                httpRequest.setMethod(HttpMethod.POST);
                httpRequest.basicAuth("test", "test");
                HttpResponse httpResponse = http.send(httpRequest);

                // then
                expectResult(httpResponse, 200, "test");
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_when_parameter_require() throws Exception
    {

        // given
        httpServerWithParameter.request(eq(form("test"), "test")).response("test");

        running(httpServerWithParameter, new java.lang.Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                httpRequest.setUrl(HOST);
                httpRequest.setMethod(HttpMethod.POST);
                httpRequest.addParameter("test", "test");
                HttpResponse httpResponse = http.send(httpRequest);

                // then
                expectResult(httpResponse, 200, "test");
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_when_body_require() throws Exception
    {

        // given
        httpServerWithBody.request(by("test")).response("test");

        running(httpServerWithBody, new java.lang.Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                httpRequest.setUrl(HOST);
                httpRequest.setMethod(HttpMethod.POST);
                httpRequest.setBody("test");
                httpRequest.setTimeout(200);
                HttpResponse httpResponse = http.send(httpRequest);

                // then
                expectResult(httpResponse, 200, "test");
            }
        });
    }

    @Test
    public void should_be_able_to_get_bad_request_when_error_occur() throws Exception
    {
        // given
        HttpClientFactory httpClientFactory = mock(HttpClientFactory.class);
        HttpRequestFactory httpRequestFactory = mock(HttpRequestFactory.class);
        HttpClient httpClient = mock(HttpClient.class);
        given(httpRequestFactory.create(any(HttpRequest.class))).willReturn(new HttpPost());
        given(httpClient.execute(any(HttpUriRequest.class))).willThrow(IOException.class);
        given(httpClientFactory.create(any(HttpRequest.class))).willReturn(httpClient);

        // when
        Http http = new Http(httpClientFactory, httpRequestFactory);
        HttpResponse httpResponse = http.send(new HttpRequest());

        // then
        expectResult(httpResponse, 400, "Bad Request");
    }

    private void expectResult(HttpResponse httpResponse, Integer statusCode, String content)
    {
        assertThat(httpResponse.getStatus(), is(statusCode));
        assertThat(httpResponse.getContent(), is(content));
    }
}
