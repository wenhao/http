package com.github.wenhao.monitor.core.http.client;

import static org.apache.commons.lang3.StringUtils.startsWithAny;

import com.github.wenhao.monitor.core.http.model.HttpRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;

public class UnsafeSSLComponent implements HttpClientComponent
{

    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return startsWithAny(httpRequest.getUrl(), "https", "HTTPS");
    }

    @Override
    public void apply(HttpClientBuilder httpClientBuilder, HttpRequest httpRequest)
    {
        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        try {
            sslContextBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            httpClientBuilder.setSSLSocketFactory(new SSLConnectionSocketFactory(sslContextBuilder.build()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
