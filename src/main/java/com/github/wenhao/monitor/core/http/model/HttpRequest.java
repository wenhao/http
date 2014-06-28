package com.github.wenhao.monitor.core.http.model;

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

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    public void setMethod(HttpMethod httpMethod)
    {
        this.httpMethod = httpMethod;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public List<NameValuePair> getParameters()
    {
        return parameters;
    }

    public void addParameter(String key, String value)
    {
        this.parameters.add(new BasicNameValuePair(key, value));
    }

    public List<Header> getHeaders()
    {
        return headers;
    }

    public void addHeader(String key, String value)
    {
        this.headers.add(new BasicHeader(key, value));
    }

    public void basicAuth(String username, String password)
    {
        String encoding = encodeBase64String((username + ":" + password).getBytes());
        this.addHeader("Authorization", "Basic " + encoding);
    }

    public HttpHost getProxy()
    {
        return proxy;
    }

    public void setProxy(String host, Integer port)
    {
        this.proxy = new HttpHost(host, port);
    }

    public Integer getTimeout()
    {
        return timeout;
    }

    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }

    public Boolean getTrustAll()
    {
        return trustAll;
    }

    public void trustAll(Boolean trustAll)
    {
        this.trustAll = trustAll;
    }
}
