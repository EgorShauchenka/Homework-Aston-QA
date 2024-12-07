package lesson17.methods.get;

import org.junit.jupiter.api.*;
import lesson17.data.DataGet;
import lesson17.spec.SpecsGet;
import lesson17.spec.SpecsPost;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class responseBodyAndResponseCodeCheck {

    @Test
    @Order(1)
    public void testGetMethod() {
        DataGet data = SpecsGet.request
                .when()
                .get("/get")
                .then()
                .spec(SpecsPost.responseSpec)
                .log().body()
                .extract().as(DataGet.class);

        Assertions.assertEquals("https", data.getHeaders().getXForwardedProto());
        Assertions.assertEquals("443", data.getHeaders().getXForwardedPort());
        Assertions.assertEquals("postman-echo.com", data.getHeaders().getHost());
        Assertions.assertNotNull(data.getHeaders().getXAmznTraceId());
        Assertions.assertEquals("application/json", data.getHeaders().getContentType());
        Assertions.assertEquals("*/*", data.getHeaders().getAccept());
        Assertions.assertNotNull(data.getHeaders().getUserAgent());
        Assertions.assertEquals("gzip,deflate", data.getHeaders().getAcceptEncoding());
        Assertions.assertEquals("https://postman-echo.com/get", data.getUrl());

    }

    @Test
    @Order(2)
    public void testGetMethodParams() {
        String foo1 = "bar1";
        String foo2 = "bar2";
        DataGet data = SpecsGet.request
                .param("foo1",foo1)
                .param("foo2",foo2)
                .when()
                .get("/get")
                .then()
                .spec(SpecsPost.responseSpec)
                .log().body()
                .extract().as(DataGet.class);

        Assertions.assertEquals("bar1", data.getArgs().foo1);
        Assertions.assertEquals("bar2", data.getArgs().foo2);
        Assertions.assertEquals("https", data.getHeaders().getXForwardedProto());
        Assertions.assertEquals("443", data.getHeaders().getXForwardedPort());
        Assertions.assertEquals("postman-echo.com", data.getHeaders().getHost());
        Assertions.assertNotNull(data.getHeaders().getXAmznTraceId());
        Assertions.assertEquals("application/json", data.getHeaders().getContentType());
        Assertions.assertEquals("*/*", data.getHeaders().getAccept());
        Assertions.assertNotNull(data.getHeaders().getUserAgent());
        Assertions.assertEquals("gzip,deflate", data.getHeaders().getAcceptEncoding());
        Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", data.getUrl());
    }
}
