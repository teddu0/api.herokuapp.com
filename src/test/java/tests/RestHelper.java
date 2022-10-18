package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestHelper {
    String uri = "https://wizard-world-api.herokuapp.com";
    public int getAllSpells(){
        RestAssured.baseURI = uri;
        Response response = given()
                .when()
                .get("/Spells");
        return response.getStatusCode();
    }

    public String getSpellsByParameters(String key, String value){
        RestAssured.baseURI = uri;
        Response response = given()
                .when()
                .param(key, value)
                .get("/Spells");
        return response.jsonPath().getString("[0]."+key);
    }


    public int getSpellByExsistingId(String id){
        RestAssured.baseURI = uri;
        Response response = given()
                .when()
                .get("/Spells/"+id);
        return response.getStatusCode();

    }

    public int getSpellByNonExsistingId(String id){
        RestAssured.baseURI = uri;
        Response response = given()
                .when()
                .get("/Spells/"+id);
        return response.getStatusCode();
    }

}
