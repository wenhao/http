package com.github.wenhao.http.core.config;

import org.apache.http.client.config.RequestConfig;

public class HttpClientConfiguration
{
    private int timeout;
    private int connectionTimeout;
    private int timeToLive;
    private int maxConnections;
    private int maxConnectionsPerRoute;
    private int keepAlive;
    private long maxIdle;
    private int retries;
    private String userAgent;
    private boolean trustAllSSL;

    public HttpClientConfiguration()
    {
        this.timeout = -1;
        this.connectionTimeout = -1;
        this.timeToLive = 1;
        this.maxConnections = 1024;
        this.maxConnectionsPerRoute = 1024;
        this.keepAlive = 0;
        this.maxIdle = 5;
        this.retries = 0;
        this.userAgent = "";
        this.trustAllSSL = false;
    }

    public int getTimeout()
    {
        return timeout;
    }

    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
    }

    public int getConnectionTimeout()
    {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout)
    {
        this.connectionTimeout = connectionTimeout;
    }

    public int getTimeToLive()
    {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive)
    {
        this.timeToLive = timeToLive;
    }

    public int getMaxConnections()
    {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections)
    {
        this.maxConnections = maxConnections;
    }

    public int getMaxConnectionsPerRoute()
    {
        return maxConnectionsPerRoute;
    }

    public void setMaxConnectionsPerRoute(int maxConnectionsPerRoute)
    {
        this.maxConnectionsPerRoute = maxConnectionsPerRoute;
    }

    public int getKeepAlive()
    {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive)
    {
        this.keepAlive = keepAlive;
    }

    public int getRetries()
    {
        return retries;
    }

    public void setRetries(int retries)
    {
        this.retries = retries;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }

    public boolean isTrustAllSSL()
    {
        return trustAllSSL;
    }

    public void setTrustAllSSL(boolean trustAllSSL)
    {
        this.trustAllSSL = trustAllSSL;
    }

    public RequestConfig getRequestConfig()
    {
        return RequestConfig.custom()
                .setConnectTimeout(this.timeout)
                .setSocketTimeout(this.timeout)
                .setConnectionRequestTimeout(this.timeout)
                .build();
    }

    public long getMaxIdle()
    {
        return maxIdle;
    }

    public void setMaxIdle(long maxIdle)
    {
        this.maxIdle = maxIdle;
    }
}
