package com.github.wenhao.http.core.client;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class UnsafeSSLComponent implements HttpClientComponent
{

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
            e.printStackTrace();
        }
    }
}
