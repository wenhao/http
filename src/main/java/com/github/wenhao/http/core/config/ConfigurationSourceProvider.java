package com.github.wenhao.http.core.config;

import java.io.IOException;

public interface ConfigurationSourceProvider
{
    HttpClientConfiguration read() throws IOException;
}
