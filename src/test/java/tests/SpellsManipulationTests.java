package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SpellsManipulationTests {
    RestHelper rh = new RestHelper();

    @Test
    @Owner("Константин В.")
    @Description("Получение всего списка заклинаний без параметров")
    public void testGettingAllSpells() {
        Assert.assertEquals(200, rh.getAllSpells());
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклинания по существующему имени")
    public void testGettingSpellByExistingNameOfSpell() {
        Assert.assertEquals("Alarte Ascendare", rh.getSpellsByParameters("name", "Alarte Ascendare"));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему типу")
    public void testGettingSpellByExistingTypeOfSpell() {
        Assert.assertEquals("Charm", rh.getSpellsByParameters("type", "Charm"));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему заклинанию")
    public void testGettingSpellByExistingSpell() {
        Assert.assertEquals("Aparecium", rh.getSpellsByParameters("incantation", "Aparecium"));
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по существующему ID")
    public void testGettingSpellByExistingId() {
        Assert.assertEquals(200, rh.getSpellByExistingId());
    }

    @Test
    @Owner("Константин В.")
    @Description("Получение заклиная по несуществующему ID")
    public void testGettingSpellByNonExistingId() {
        Assert.assertEquals(404, rh.getSpellByNonExistingId());
    }
}
