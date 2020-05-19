package org.acme.getting.started;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.CoreMatchers;

@QuarkusTest
@QuarkusTestResource(HelloWorldQuarkusTestResourcesLifecycleManager.class)
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is(CoreMatchers.is("ALOHA TEST")));
    }

    @Test
    public void should_return_hello(){
        given()
        .when().get("/hello/beer")
        .then()
           .statusCode(200);
        //    .body(is(CoreMatchers.is("{'capacity':'600','name':'Pilsen'}")));
    }
}