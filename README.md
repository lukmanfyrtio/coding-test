# coding-test
spring boot app for coding test 
## Requirements

For building and running the application you need:
- [JDK 18](https://www.oracle.com/java/technologies/downloads/#java18)
- [Maven](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.sekolahkripto.codingtest.CodingTestApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
And for running unit test you can use:

```shell
mvn test
```
# REST API


## Call the API 

### Request on cmd , terminal or you can go to [curl directly from your browser](https://reqbin.com/req/c-dwjszac0/curl-post-json-example)

`POST /api/v1/test`
```shell
    curl -X POST  http://localhost:8080/api/v1/test
   -H "Content-Type: application/json"
   -d '[{"model":"S","color":"Black"},{"color":"none","model":"S"}]'  
   ```

### Response
```shell
HTTP/1.1 200 
connection: keep-alive
content-type: application/json
date: Fri, 22 Jul 2022 10:01:11 GMT
keep-alive: timeout=60
transfer-encoding: chunked

{"data":[{"color":"Black","model":"S"}],"status":200}
   ```
