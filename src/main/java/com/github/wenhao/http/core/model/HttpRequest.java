package com.github.wenhao.http.core.model;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequest
{

    private String url;
    private HttpMethod httpMethod;
    private String body;
    private List<Header> headers;
    private List<NameValuePair> parameters;
    private HttpHost proxy;
    private Integer timeout;
    private Boolean trustAll;

    public HttpRequest()
    {
        this.parameters = new ArrayList<NameValuePair>();
        this.headers = new ArrayList<Header>();
        this.trustAll = false;
    }

    public HttpRequest host(String url)
    {
        this.url = url;
        return this;
    }

    public String getUrl()
    {
        return url;
    }

    public HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    public HttpRequest method(HttpMethod httpMethod)
    {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getBody()
    {
        return body;
    }

    public HttpRequest body(String body)
    {
        this.body = body;
        return this;
    }

    public List<NameValuePair> getParameters()
    {
        return parameters;
    }

    public HttpRequest parameter(String key, String value)
    {
        this.parameters.add(new BasicNameValuePair(key, value));
        return this;
    }

    public List<Header> getHeaders()
    {
        return headers;
    }

    public HttpRequest header(String key, String value)
    {
        this.headers.add(new BasicHeader(key, value));
        return this;
    }

    public HttpRequest basicAuth(String username, String password)
    {
        String encoding = encodeBase64String((username + ":" + password).getBytes());
        this.header("Authorization", "Basic " + encoding);
        return this;
    }

    public HttpHost getProxy()
    {
        return proxy;
    }

    public HttpRequest proxy(String host, Integer port)
    {
        this.proxy = new HttpHost(host, port);
        return this;
    }

    public Integer getTimeout()
    {
        return timeout;
    }

    public HttpRequest timeout(Integer timeout)
    {
        this.timeout = timeout;
        return this;
    }

    public Boolean getTrustAll()
    {
        return trustAll;
    }

    public HttpRequest trustAll(Boolean trustAll)
    {
        this.trustAll = trustAll;
        return this;
    }
}
