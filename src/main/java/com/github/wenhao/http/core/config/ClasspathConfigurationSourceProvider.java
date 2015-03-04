package com.github.wenhao.http.core.config;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ClasspathConfigurationSourceProvider implements ConfigurationSourceProvider
{
    private static final String CONFIGURATION_FILE = "/http.yaml";
    @Override
    public HttpClientConfiguration read() throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(this.getClass().getResourceAsStream(CONFIGURATION_FILE), HttpClientConfiguration.class);
    }
}
