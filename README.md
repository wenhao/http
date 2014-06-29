[![Build Status](https://travis-ci.org/wenhao/http.png?branch=master)](https://travis-ci.org/wenhao/http)

## [http](https://github.com/wenhao/http)
Make GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS requests
* It supports form parameters, file uploads and custom body entities
* Easily add route parameters without ugly string concatenations
* Supports gzip
* Supports Basic Authentication natively
* Customizable timeout
* Customizable headers for every request

## Usage

### Installing

#### With Maven
You can use Maven by including the library:

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

### Create Request

So you're probably wondering how using Unirest makes creating requests in Java easier, 
here is a basic POST request that will explain everything:


```java
HttpRequest httpRequest = new HttpRequest();
httpRequest.setUrl("https://localhost:8080");
httpRequest.setMethod(POST);

Http http = HttpFactory.create();
http.setRequest(httpRequest);

HttpResponse httpResponse = http.send();

```

### Spring Integration

```xml
<bean id="http" class="com.github.wenhao.http.core.HttpFactory" factory-method="create" />

```

### Custom Parameter

```java
httpRequest.addParameter("key", "value");

```


### Custom Entity Body

```java
httpRequest.setBody("body");

```

### Basic Authentication

```java
httpRequest.basicAuth("username", "password");

```

### Request

You start building your request by creating a HttpRequest object using one of the following:

```java
HttpRequest httpRequest = new HttpRequest();
httpRequest.setUrl("https://localhost:8080");
httpRequest.setMethod(POST); // GET/HEAD/POST/PUT/PATCH/OPTIONS/DELETE

```

### Response

Upon receiving a response http returns the result in the form of an Object, this object should always have the same keys for each language regarding to the response details.

.getStatus() - HTTP Response Status Code (Example 200)

.getContent() - Parsed response body.

As shown above, we created a new http Request and expect get httpResponse. It will trust all certificates if url start
with https.

## Advanced Configuration
### Timeouts
You can set custom connection and socket timeout values (in milliseconds):
```java
httpRequest.setTimeout(5000);

```

### Request Headers
You can add headers that will be sent on every request:
```java
httpRequest.addHeader("key", "value");

```

### Trust All Certification

```java
httpRequest.trustAll(true);

```

## Copyright and license

Copyright 2014 Wen Hao

Licensed under [Apache License][1]

[1]: https://github.com/wenhao/http/blob/master/LICENSE



