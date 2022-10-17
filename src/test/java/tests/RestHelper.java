package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestHelper {
    String uri = "https://wizard-world-api.herokuapp.com";
    public void getAllSpells(){
        RestAssured.baseURI = uri;
        given()
                .when()
                .get("/Spells")
                .then()
                .statusCode(200)
                .extract().response().prettyPrint();
    }

    public void getSpellsByParameters(String key, String value){
        RestAssured.baseURI = uri;
        given()
                .when()
                .param(key, value)
                .get("/Spells")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("[0]."+key, equalTo(value))
                .extract().response().prettyPrint();
    }


    public void getSpellByExsistingId(String id){
        RestAssured.baseURI = uri;
        given()
                .when()
                .get("/Spells/"+id)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().response().prettyPrint();
    }

    public void getSpellByNonExsistingId(String id){
        RestAssured.baseURI = uri;
        given()
                .when()
                .get("/Spells/"+id)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(404)
                .body("title", equalTo("Spell not found with id "+id))
                .extract().response().prettyPrint();
    }

}
