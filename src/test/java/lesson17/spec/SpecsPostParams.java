package lesson17.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class SpecsPostParams {
    public static RequestSpecification request = with()
            .baseUri("https://postman-echo.com/")
            .log().all()
            .contentType(ContentType.URLENC.withCharset("UTF-8"));

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
