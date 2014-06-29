package com.github.wenhao.http.core.client;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.conn.ssl.TrustStrategy;

public class TrustAllSignedStrategy implements TrustStrategy
{
    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException
    {
        return true;
    }
}
