package lesson17.methods.post;

import org.junit.jupiter.api.*;
import lesson17.data.DataPost;
import lesson17.spec.SpecsPost;
import lesson17.spec.SpecsPostParams;

import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class responseBodyAndResponseCodeCheck {
    @Test
    @Order(1)
    public void testPostMethod() {
        String param = "{\n    \"test\": \"value\"\n}";

        DataPost dataPost = SpecsPost.request
                .when()
                .body(param)
                .post("/post")
                .then()
                .spec(SpecsPost.responseSpec)
                .log().body()
                .extract().as(DataPost.class);

        Assertions.assertEquals("https", dataPost.getHeaders().getXForwardedProto());
        Assertions.assertEquals("443", dataPost.getHeaders().getXForwardedPort());
        Assertions.assertEquals("postman-echo.com", dataPost.getHeaders().getHost());
        Assertions.assertNotNull(dataPost.getHeaders().getXAmznTraceId());
        Assertions.assertEquals("23", dataPost.getHeaders().getContentLength());
        Assertions.assertEquals("text/plain; charset=ISO-8859-1", dataPost.getHeaders().getContentType());
        Assertions.assertNotNull(dataPost.getHeaders().getUserAgent());
        Assertions.assertEquals("*/*", dataPost.getHeaders().getAccept());
        Assertions.assertNull(dataPost.getHeaders().getCacheControl());
        Assertions.assertNull(dataPost.getHeaders().getPostmanToken());
        Assertions.assertEquals("gzip,deflate", dataPost.getHeaders().getAcceptEncoding());
        Assertions.assertNull(dataPost.getHeaders().getCookie());
        Assertions.assertNull(dataPost.getJson());
        Assertions.assertEquals("https://postman-echo.com/post", dataPost.getUrl());
    }

    @Test
    @Order(2)
    public void testPostMethodParams() {
        Map<String, String> params = new HashMap<>();
        params.put("foo1", "bar1");
        params.put("foo2", "bar2");

        DataPost dataPost = SpecsPostParams.request
                .urlEncodingEnabled(false)
                .when()
                .formParams(params)
                .post("/post")
                .then()
                .spec(SpecsPostParams.responseSpec)
                .log().body()
                .extract().as(DataPost.class);

        Assertions.assertEquals("https", dataPost.getHeaders().getXForwardedProto());
        Assertions.assertEquals("443", dataPost.getHeaders().getXForwardedPort());
        Assertions.assertEquals("postman-echo.com", dataPost.getHeaders().getHost());
        Assertions.assertNotNull(dataPost.getHeaders().getXAmznTraceId());
        Assertions.assertEquals("application/x-www-form-urlencoded; charset=UTF-8", dataPost.getHeaders().getContentType());
        Assertions.assertNotNull(dataPost.getHeaders().getUserAgent());
        Assertions.assertEquals("*/*", dataPost.getHeaders().getAccept());
        Assertions.assertNull(dataPost.getHeaders().getCacheControl());
        Assertions.assertNull(dataPost.getHeaders().getPostmanToken());
        Assertions.assertEquals("gzip,deflate", dataPost.getHeaders().getAcceptEncoding());
        Assertions.assertNull(dataPost.getHeaders().getCookie());
        Assertions.assertEquals(params,dataPost.getJson());
        Assertions.assertEquals("https://postman-echo.com/post", dataPost.getUrl());
    }
}
