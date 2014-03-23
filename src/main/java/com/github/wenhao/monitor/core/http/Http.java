package com.github.wenhao.monitor.core.http;

import java.io.IOException;

import com.github.wenhao.monitor.core.http.client.HttpClientFactory;
import com.github.wenhao.monitor.core.http.method.HttpRequestFactory;
import com.github.wenhao.monitor.core.http.model.HttpRequest;
import com.github.wenhao.monitor.core.http.model.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;

public class Http
{

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
        HttpClient httpClient = httpClientFactory.create(httpRequest);
        HttpUriRequest httpUriRequest = httpRequestFactory.create(httpRequest);

        try {
            return execute(httpClient, httpUriRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HttpResponse(400, BAD_REQUEST);
    }

    private HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException
    {
        org.apache.http.HttpResponse httpHttpResponse = httpClient.execute(httpUriRequest);
        int statusCode = httpHttpResponse.getStatusLine().getStatusCode();
        String content = parseResponse(httpHttpResponse);
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

}
