package com.github.wenhao.http;

import java.io.IOException;

import com.github.wenhao.http.client.HttpClientFactory;
import com.github.wenhao.http.method.HttpRequestFactory;
import com.github.wenhao.http.model.Request;
import com.github.wenhao.http.model.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;

public class Http
{

    private static final String BAD_REQUEST = "Bad Request";
    private HttpClientFactory httpClientFactory;
    private HttpRequestFactory httpRequestFactory;
    private Request request;

    public Http(HttpClientFactory httpClientFactory, HttpRequestFactory httpRequestFactory)
    {
        this.httpClientFactory = httpClientFactory;
        this.httpRequestFactory = httpRequestFactory;
    }

    public Response send()
    {
        HttpClient httpClient = httpClientFactory.create(request);
        HttpUriRequest httpUriRequest = httpRequestFactory.create(request);

        try {
            return execute(httpClient, httpUriRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response(400, BAD_REQUEST);
    }

    private Response execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException
    {
        HttpResponse httpResponse = httpClient.execute(httpUriRequest);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String content = parseResponse(httpResponse);
        return new Response(statusCode, content);
    }

    private String parseResponse(HttpResponse httpResponse)
    {
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            return responseHandler.handleResponse(httpResponse);
        } catch (IOException e) {
            return httpResponse.getStatusLine().getReasonPhrase();
        }
    }

    public void setRequest(Request request)
    {
        this.request = request;
    }
}
