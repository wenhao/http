package com.github.wenhao.http.core.client;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class HttpKeepAliveStrategy implements ConnectionKeepAliveStrategy
{
    private long defaultDuration;

    public HttpKeepAliveStrategy(long defaultDuration)
    {
        this.defaultDuration = defaultDuration;
    }

    @Override
    public long getKeepAliveDuration(final HttpResponse response, final HttpContext context)
    {
        final HeaderElementIterator it = new BasicHeaderElementIterator(
                response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while (it.hasNext()) {
            final HeaderElement he = it.nextElement();
            final String param = he.getName();
            final String value = he.getValue();
            if (value != null && param.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 1000;
                } catch (final NumberFormatException ignore) {
                }
            }
        }
        return this.defaultDuration;
    }
}
