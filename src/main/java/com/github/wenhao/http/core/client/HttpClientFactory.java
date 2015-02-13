package com.github.wenhao.http.core.client;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

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

    public HttpClientFactory()
    {

    }

    public CloseableHttpClient create()
    {
        HttpClientConfiguration httpClientConfiguration = new HttpClientConfiguration();

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
