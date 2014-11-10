package com.github.wenhao.http.core.entity;

import com.github.wenhao.http.core.model.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

public class FileEntity implements HttpEntityComponent
{
    @Override
    public Boolean isApplicable(HttpRequest httpRequest)
    {
        return httpRequest.getFile() != null;
    }

    @Override
    public HttpEntity apply(HttpRequest httpRequest)
    {
        FileBody fileBody = new FileBody(httpRequest.getFile());
        return MultipartEntityBuilder.create()
                .addPart("bin", fileBody)
                .build();
    }
}
