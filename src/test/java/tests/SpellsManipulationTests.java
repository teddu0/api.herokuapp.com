package tests;

import dto.ErrorMessage;
import dto.ModelClass;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.helper.TestClient;

import java.util.Arrays;
import java.util.List;


public class SpellsManipulationTests {
    TestClient rh = new TestClient();

    @Test
    @Owner("Константин В.")
    @Description("Получение всего списка заклинаний без параметров")
    public void testGettingAllSpells() {
        List<ModelClass> array = Arrays.stream(rh.getAllSpells()
                        .then()
                        .extract()
                        .as(ModelClass[].class))
                .toList();
        Assert.assertNotNull(array);
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклинания по существующему имени")
    public void testGettingSpellByExistingNameOfSpell() {
        List<ModelClass> array = Arrays.stream(rh.getSpellsByParameters("name", "Alarte Ascendare")
                        .then()
                        .extract()
                        .as(ModelClass[].class))
                .toList();
        Assert.assertEquals("Alarte Ascendare", array.get(0).getName());
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему типу")
    public void testGettingSpellByExistingTypeOfSpell() {
        List<ModelClass> array = Arrays.stream(rh.getSpellsByParameters("type", "Charm")
                        .then()
                        .extract()
                        .as(ModelClass[].class))
                .toList();
        Assert.assertEquals("Charm", array.get(0).getType());
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему заклинанию")
    public void testGettingSpellByExistingSpell() {
        List<ModelClass> array = Arrays.stream(rh.getSpellsByParameters("incantation", "Aparecium")
                        .then()
                        .extract()
                        .as(ModelClass[].class))
                .toList();
        Assert.assertEquals("Aparecium", array.get(0).getIncantation());
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему ID")
    public void testGettingSpellByExistingId() {
        ModelClass modelClass = rh.getSpellByExistingId()
                .then()
                .extract()
                .as(ModelClass.class);
        Assert.assertNotNull(modelClass);
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по несуществующему ID")
    public void testGettingSpellByNonExistingId() {
        ErrorMessage errorMessage = rh.getSpellByNonExistingId()
                .then()
                .extract()
                .as(ErrorMessage.class);
        Assert.assertEquals("404", errorMessage.getStatus());
        Assert.assertEquals("Spell not found with id 99170271-1b6a-4c10-a947-37ee558b6c83", errorMessage.getTitle());
    }
}
