package com.github.wenhao.http.core.client;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsafeSSLComponent implements HttpClientComponent
{

    private static final Logger LOGGER = LoggerFactory.getLogger(UnsafeSSLComponent.class);

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getTrustAll() && (httpRequest.getUrl().startsWith("https") || httpRequest.getUrl().startsWith("HTTPS"));
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest)
    {
        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        try {
            sslContextBuilder.loadTrustMaterial(null, new TrustAllSignedStrategy());
            httpClientBuilder.setSSLSocketFactory(new SSLConnectionSocketFactory(sslContextBuilder.build()));
        } catch (Exception e) {
            LOGGER.debug("Fail to trust all certificates", e);
        }
    }
}
