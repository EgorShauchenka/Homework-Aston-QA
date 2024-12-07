package lesson17.methods.delete;

import lesson17.data.DataDelete;
import org.junit.jupiter.api.*;
import lesson17.spec.SpecsDelete;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class responseBodyAndResponseCodeCheck {
    @Test
    @Order(1)
    public void testDeleteMethod() {
        String data = "This is expected to be sent back as part of response body.";

        DataDelete dataDelete = SpecsDelete.request
                .when()
                .body(data)
                .delete("delete")
                .then()
                .spec(SpecsDelete.responseSpec)
                .log().body()
                .extract().as(DataDelete.class);

        Assertions.assertEquals("https", dataDelete.getHeaders().getXForwardedProto());
        Assertions.assertEquals("443", dataDelete.getHeaders().getXForwardedPort());
        Assertions.assertEquals("postman-echo.com", dataDelete.getHeaders().getHost());
        Assertions.assertNotNull(dataDelete.getHeaders().getXAmznTraceId());
        Assertions.assertEquals("58", dataDelete.getHeaders().getContentLength());
        Assertions.assertEquals("text/plain; charset=ISO-8859-1", dataDelete.getHeaders().getContentType());
        Assertions.assertNotNull(dataDelete.getHeaders().getUserAgent());
        Assertions.assertEquals("*/*", dataDelete.getHeaders().getAccept());
        Assertions.assertNull(dataDelete.getHeaders().getCacheControl());
        Assertions.assertNull(dataDelete.getHeaders().getPostmanToken());
        Assertions.assertEquals("gzip,deflate", dataDelete.getHeaders().getAcceptEncoding());
        Assertions.assertNull(dataDelete.getHeaders().getCookie());
        Assertions.assertNull(dataDelete.getJson());
        Assertions.assertEquals("https://postman-echo.com/delete", dataDelete.getUrl());
    }
}