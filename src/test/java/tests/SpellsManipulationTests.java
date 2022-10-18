package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class SpellsManipulationTests extends TestBase {
    RestHelper rh = new RestHelper();

    @Test
    @Owner("Константин В.")
    @Description("Получение всего списка заклинаний без параметров")
    public void testGettingAllSpells(){
        rh.getAllSpells();
        Assert.assertEquals(200, rh.getAllSpells());
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклинания по существующему имени")
    public void testGettingSpellByExistingNameOfSpell(){
        rh.getSpellsByParameters("name", "Alarte Ascendare");
        Assert.assertEquals("Alarte Ascendare", rh.getSpellsByParameters("name", "Alarte Ascendare"));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему типу")
    public void testGettingSpellByExistingTypeOfSpell(){
        rh.getSpellsByParameters("type", "Charm");
        Assert.assertEquals("Charm", rh.getSpellsByParameters("type", "Charm"));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему заклинанию")
    public void testGettingSpellByExistingSpell(){
        rh.getSpellsByParameters("incantation", "Aparecium");
        Assert.assertEquals("Aparecium", rh.getSpellsByParameters("incantation", "Aparecium"));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему ID")
    public void testGettingSpellByExistingId(){
        rh.getSpellByExsistingId(EXISTING_ID_OF_SPELL);
        Assert.assertEquals(200, rh.getSpellByExsistingId(EXISTING_ID_OF_SPELL));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по несуществующему ID")
    public void testGettingSpellByNonExistingId(){
        rh.getSpellByNonExsistingId(NON_EXISTING_ID_OF_SPELL);
        Assert.assertEquals(404, rh.getSpellByNonExsistingId(NON_EXISTING_ID_OF_SPELL));
    }
}
