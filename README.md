[![Build Status](https://travis-ci.org/wenhao/monitor-core.png?branch=master)](https://travis-ci.org/wenhao/monitor-core)

## [Monitor-core](https://github.com/wenhao/monitor-core)
monitor-core is a framework, mainly focusing on monitoring over network protocol, especially test HTTP, TCP,
UPD, database connection, web service, REST etc.

## Features
* support HTTP protocol(restful service, web service, etc.).

## Usage

monitor-code support multiple network protocol.

## API

### dependency

monitor-core has been published on Maven repository, so you can refer to it directly in your dependency. This is core
dependency

```xml
<dependency>
  <groupId>com.github.wenhao</groupId>
  <artifactId>monitor-core</artifactId>
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
    "com.github.wenhao:monitor-core:0.0.1-SNAPSHOT",
  )
}
```

### API example

Here is an typical http request.

```java
Request request = new Request();
request.setUrl("https://localhost:8080");
request.basicAuth("username", "password");
request.addHeader("key", "value");
request.addParameter("key", "value");
request.setProxy("http://proxy.com", 9000);
request.setTimeout(5);

Http http = HttpFactory.create();
http.setRequest(request);

Response response = http.send();

```

As shown above, we created a new http request and expect get response. Tt will trust all certificates if url start
with https.

## Copyright and license

Copyright 2014 Wen Hao

Licensed under [Apache License][1]

[1]: https://github.com/wenhao/monitor-core/blob/master/LICENSE



