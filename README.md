[![Build Status](https://travis-ci.org/wenhao/http.png?branch=master)](https://travis-ci.org/wenhao/http)

## [http](https://github.com/wenhao/http)
Make GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS requests
* Support for all the commonly used MIME types like JSON, XML, ATOM and YAML
* Enable both HTTP and HTTPS (SSL) invocation of web services
* It supports form parameters, file uploads and custom body entities
* Easily add route parameters without ugly string concatenations
* Supports Basic Authentication natively
* Customizable headers for every request
* Full awareness of proxies.
* Customizable timeout
* Supports gzip
* Good Test Coverage via a comprehensive set of developer tests, providing assurance of the library's quality
* The number of external dependencies is minimised (currently: slf4j, httpmime)
* Auto release/close http resource

## Usage

### Installing

Repository/Artifact available here

[https://oss.sonatype.org](https://oss.sonatype.org/#nexus-search;gav~com.github.wenhao~http~~~)

#### With Maven
You can use Maven by including the library:

http has been published on Maven repository, so you can refer to it directly in your dependency. This is core
dependency

```xml
<dependency>
  <groupId>com.github.wenhao</groupId>
  <artifactId>http</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### With Gradle
A gradle example is as follow:

```groovy
repositories {
  mavenCentral()
}

dependencies {
  compile(
    "com.github.wenhao:http:1.0.0",
  )
}
```

### Create Request

So you're probably wondering how using Unirest makes creating requests in Java easier, 
here is a basic POST request that will explain everything:


```java
HttpRequest httpRequest = new HttpRequest()
  .host("https://localhost:8080")
  .method(POST)
  .header("accept", "application/json")
  .parameter("key", "value");

Http http = HttpFactory.create();

HttpResponse httpResponse = http.send(httpRequest);

```

### Spring Integration

```xml
<bean id="http" class="com.github.wenhao.http.core.HttpFactory" factory-method="create" />

```
```java
public class HttpService
{
    @Autowired
    private Http http;
}
```

### Custom Parameter

```java
HttpRequest httpRequest = new HttpRequest()
  .host("https://localhost:8080")
  .method(POST)
  .parameter("key", "value")
  .parameter("parameter", "value");

```

###File Uploads

Creating multipart requests with Java is trivial, simply pass along a File Object as a field:

```java
HttpRequest httpRequest = new HttpRequest()
  .host("https://localhost:8080")
  .method(POST)
  .parameter("key", "value")
  .file(new File("/tmp/file"));

```

### Custom Entity Body

```java
HttpRequest httpRequest = new HttpRequest()
  .host("https://localhost:8080")
  .method(POST)
  .header("accept", "application/json")
  .body("body");

```

### Basic Authentication

```java
HttpRequest httpRequest = new HttpRequest()
  .host("https://localhost:8080")
  .method(POST)
  .basicAuth("username", "password");

```

### Request

You start building your request by creating a HttpRequest object using one of the following:

```java
HttpRequest httpRequest = new HttpRequest();
  .host("https://localhost:8080")
  .method(POST); // GET/HEAD/POST/PUT/PATCH/OPTIONS/DELETE

```

### Response

Upon receiving a response http returns the result in the form of an Object, this object should always have the same keys for each language regarding to the response details.

.getStatus() - HTTP Response Status Code (Example 200)

.getContent() - Parsed response body.

As shown above, we created a new http Request and expect get httpResponse. It will trust all certificates if url start
with https.

## Advanced Configuration
You can configure more things via a configuration file(http.yaml in classpath):
```yaml
timeout: 500
connectionTimeout: 500
timeToLive: 3600000
maxConnections: 1024
maxConnectionsPerRoute: 1024
maxIdle: 10
keepAlive: 5
retries: 0
userAgent: "HTTP Application"
trustAllSSL: true
```


## Copyright and license

Copyright 2014 Wen Hao

Licensed under [Apache License][1]

[1]: https://github.com/wenhao/http/blob/master/LICENSE



