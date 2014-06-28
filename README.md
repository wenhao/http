[![Build Status](https://travis-ci.org/wenhao/http.png?branch=master)](https://travis-ci.org/wenhao/http)

## [http](https://github.com/wenhao/http)

## Usage

monitor-code support multiple network protocol.

## API

### dependency

http has been published on Maven repository, so you can refer to it directly in your dependency. This is core
dependency

```xml
<dependency>
  <groupId>com.github.wenhao</groupId>
  <artifactId>http</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

A gradle example is as follow:

```groovy
repositories {
  mavenCentral()
}

dependencies {
  testCompile(
    "com.github.wenhao:http:0.0.1-SNAPSHOT",
  )
}
```

### API example

Here is an typical http Request.

```java
HttpRequest httpRequest = new HttpRequest();
httpRequest.setUrl("https://localhost:8080");
httpRequest.basicAuth("username", "password");
httpRequest.addHeader("key", "value");
httpRequest.addParameter("key", "value");
httpRequest.setProxy("http://proxy.com", 9000);
httpRequest.setTimeout(5);

Http http = HttpFactory.create();
http.setRequest(httpRequest);

HttpResponse httpResponse = http.send();

```

As shown above, we created a new http Request and expect get httpResponse. It will trust all certificates if url start
with https.

## Copyright and license

Copyright 2014 Wen Hao

Licensed under [Apache License][1]

[1]: https://github.com/wenhao/http/blob/master/LICENSE



