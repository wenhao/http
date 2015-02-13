package com.github.wenhao.http.core;

import java.io.IOException;

import com.github.wenhao.http.core.client.HttpClientFactory;
import com.github.wenhao.http.core.method.HttpRequestFactory;
import com.github.wenhao.http.core.model.HttpRequest;
import com.github.wenhao.http.core.model.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Http
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Http.class);
    private static final String BAD_REQUEST = "Bad Request";
    private HttpClientFactory httpClientFactory;
    private HttpRequestFactory httpRequestFactory;

    public Http(HttpClientFactory httpClientFactory, HttpRequestFactory httpRequestFactory)
    {
        this.httpClientFactory = httpClientFactory;
        this.httpRequestFactory = httpRequestFactory;
    }

    public HttpResponse send(HttpRequest httpRequest)
    {
        CloseableHttpClient httpClient = httpClientFactory.create();
        HttpUriRequest httpUriRequest = httpRequestFactory.create(httpRequest);

        try {
            return execute(httpClient, httpUriRequest);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return new HttpResponse(400, BAD_REQUEST);
        } finally {
            closeHttpClient(httpClient);
        }
    }

    private HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException
    {
        org.apache.http.HttpResponse httpResponse = httpClient.execute(httpUriRequest);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String content = parseResponse(httpResponse);
        HttpClientUtils.closeQuietly(httpClient);
        return new HttpResponse(statusCode, content);
    }

    private String parseResponse(org.apache.http.HttpResponse httpHttpResponse)
    {
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            return responseHandler.handleResponse(httpHttpResponse);
        } catch (IOException e) {
            return httpHttpResponse.getStatusLine().getReasonPhrase();
        }
    }

    private void closeHttpClient(CloseableHttpClient httpClient)
    {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
