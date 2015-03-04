package com.github.wenhao.http.core.client;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.io.IOException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import com.github.wenhao.http.core.config.ConfigurationSourceProvider;
import com.github.wenhao.http.core.config.HttpClientConfiguration;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientFactory
{

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientFactory.class);
    private ConfigurationSourceProvider configurationSourceProvider;

    public HttpClientFactory(ConfigurationSourceProvider configurationSourceProvider)
    {
        this.configurationSourceProvider = configurationSourceProvider;
    }

    public CloseableHttpClient create()
    {
        HttpClientConfiguration httpClientConfiguration = readConfiguration();

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setDefaultRequestConfig(httpClientConfiguration.getRequestConfig())
                .setMaxConnTotal(httpClientConfiguration.getMaxConnections())
                .setMaxConnPerRoute(httpClientConfiguration.getMaxConnectionsPerRoute())
                .setUserAgent(httpClientConfiguration.getUserAgent())
                .evictIdleConnections(httpClientConfiguration.getMaxIdle(), MILLISECONDS)
                .setConnectionTimeToLive(httpClientConfiguration.getTimeToLive(), MILLISECONDS)
                .setKeepAliveStrategy(new HttpKeepAliveStrategy(httpClientConfiguration.getKeepAlive()))
                .setRetryHandler(new DefaultHttpRequestRetryHandler(httpClientConfiguration.getRetries(), false));

        configSSL(httpClientBuilder, httpClientConfiguration.isTrustAllSSL());
        return httpClientBuilder.build();
    }

    private HttpClientConfiguration readConfiguration()
    {
        try {
            return configurationSourceProvider.read();
        } catch (IOException e) {
            LOGGER.debug("Fail to load http.properties configuration file", e);
        }
        return new HttpClientConfiguration();
    }

    private void configSSL(HttpClientBuilder httpClientBuilder, boolean isTrustAllSSL)
    {
        if (isTrustAllSSL) {
            try {
                httpClientBuilder.setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext()));
            } catch (Exception e) {
                LOGGER.debug("Fail to trust all certificates", e);
            }
        }
    }

    private SSLContext sslContext() throws Exception
    {
        return SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy()
        {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType)
            {
                return true;
            }
        }).build();
    }
}
