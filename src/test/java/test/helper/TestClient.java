package test.helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class TestClient {

    private final String URI = "https://wizard-world-api.herokuapp.com";
    private final String SPELLS_PATH = "/Spells";
    private final String VALID_SPELL_PATH = SPELLS_PATH + "/6bed818d-1006-4b52-9d64-e8738077fc1f";
    private final String INVALID_SPELL_PATH = SPELLS_PATH + "/99170271-1b6a-4c10-a947-37ee558b6c83";

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(URI)
            .setAccept(ContentType.JSON)
            .build();

    public Response getAllSpells() {
        return given()
                .spec(requestSpecification)
                .when()
                .get(SPELLS_PATH);

    }

    public Response getSpellsByParameters(String key, String value) {
        return given()
                .spec(requestSpecification)
                .when()
                .param(key, value)
                .get(SPELLS_PATH);
    }

    public Response getSpellByExistingId() {
        return given()
                .spec(requestSpecification)
                .when()
                .get(VALID_SPELL_PATH);
    }

    public Response getSpellByNonExistingId() {
        return given()
                .spec(requestSpecification)
                .when()
                .get(INVALID_SPELL_PATH);
    }

}
