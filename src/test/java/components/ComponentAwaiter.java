package components;

import static io.restassured.RestAssured.given;

public class ComponentAwaiter {
    public static String ExecuteRequest(String endpoint) {
        return given().when().get(endpoint).then().extract().asString();
    }
}
