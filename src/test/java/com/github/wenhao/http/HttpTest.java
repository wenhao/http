package com.github.wenhao.http;

import static com.github.dreamhead.moco.Moco.by;
import static com.github.dreamhead.moco.Moco.eq;
import static com.github.dreamhead.moco.Moco.form;
import static com.github.dreamhead.moco.Moco.header;
import static com.github.dreamhead.moco.Moco.httpserver;
import static com.github.dreamhead.moco.Runner.running;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static se.jbee.inject.Dependency.dependency;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runnable;
import com.github.wenhao.http.dependencies.RootBundle;
import com.github.wenhao.http.model.HttpMethod;
import com.github.wenhao.http.model.Request;
import com.github.wenhao.http.model.Response;
import org.junit.Before;
import org.junit.Test;
import se.jbee.inject.Injector;
import se.jbee.inject.bootstrap.Bootstrap;

public class HttpTest
{

    private static final String HOST = "http://localhost:9999";
    private HttpServer httpserver;
    private Http http;
    private Request request;
    private HttpServer httpServerWithHeader;
    private HttpServer httpServerWithParameter;
    private HttpServer httpServerWithBody;
    private HttpServer httpServerWithoutBody;

    @Before
    public void setUp() throws Exception
    {
        httpserver = httpserver(9999);
        httpserver.response("test");
        httpServerWithHeader = httpserver(9999);
        httpServerWithParameter = httpserver(9999);
        httpServerWithBody = httpserver(9999);

        Injector injector = Bootstrap.injector(RootBundle.class);
        http = injector.resolve(dependency(Http.class));
        request = new Request();
    }

    @Test
    public void should_be_able_to_get_response_via_get_method() throws Exception
    {
        running(httpserver, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.GET);
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(200));
                assertThat(response.getContent(), is("test"));
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_method() throws Exception
    {
        running(httpserver, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.POST);
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(200));
                assertThat(response.getContent(), is("test"));
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_when_basic_auth_require() throws Exception
    {

        // given
        httpServerWithHeader.request(eq(header("Authorization"), "Basic dGVzdDp0ZXN0")).response("test");

        running(httpServerWithHeader, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.POST);
                request.basiAuth("test", "test");
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(200));
                assertThat(response.getContent(), is("test"));
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_when_header_require() throws Exception
    {

        // given
        httpServerWithHeader.request(eq(header("test"), "test")).response("test");

        running(httpServerWithHeader, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.POST);
                request.addHeader("test", "test");
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(200));
                assertThat(response.getContent(), is("test"));
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_when_parameter_require() throws Exception
    {

        // given
        httpServerWithParameter.request(eq(form("test"), "test")).response("test");

        running(httpServerWithParameter, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.POST);
                request.addParameter("test", "test");
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(200));
                assertThat(response.getContent(), is("test"));
            }
        });
    }

    @Test
    public void should_be_able_to_get_response_via_post_when_body_require() throws Exception
    {

        // given
        httpServerWithBody.request(by("test")).response("test");

        running(httpServerWithBody, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.POST);
                request.setBody("test");
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(200));
                assertThat(response.getContent(), is("test"));
            }
        });
    }

    @Test
    public void should_raise_error() throws Exception
    {

        // given
        httpServerWithoutBody = httpserver(9999);
        httpServerWithoutBody.request(by("test")).response("test");

        running(httpServerWithoutBody, new Runnable()
        {
            @Override
            public void run() throws Exception
            {
                // when
                request.setUrl(HOST);
                request.setMethod(HttpMethod.POST);
                http.setRequest(request);
                Response response = http.send();

                // then
                assertThat(response.getStatus(), is(400));
                assertThat(response.getContent(), is("Bad Request"));
            }
        });
    }
}
