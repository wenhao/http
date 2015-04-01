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
        final HeaderElementIterator headerElementIterator = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while (headerElementIterator.hasNext()) {
            final HeaderElement headerElement = headerElementIterator.nextElement();
            final String parameter = headerElement.getName();
            final String value = headerElement.getValue();
            if (value != null && parameter.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value);
                } catch (final NumberFormatException ignore) {
                    ignore.printStackTrace();
                }
            }
        }
        return this.defaultDuration;
    }
}
