package tests;

import org.testng.annotations.Test;


public class SpellsManipulationTests extends TestBase {
    RestHelper rh = new RestHelper();

    @Test (description = "Получение всего списка заклинаний без параметров")
    public void testGettingAllSpells(){
        rh.getAllSpells();
    }

    @Test (description = "Получение заклинания по существующему имени")
    public void testGettingSpellByExistingNameOfSpell(){
        rh.getSpellsByParameters("name", "Alarte Ascendare");
    }

    @Test (description = "Получение заклиная по существующему типу")
    public void testGettingSpellByExistingTypeOfSpell(){
        rh.getSpellsByParameters("type", "Charm");
    }

    @Test (description = "Получение заклиная по существующему заклинанию")
    public void testGettingSpellByExistingSpell(){
        rh.getSpellsByParameters("incantation", "Aparecium");
    }

    @Test (description = "Получение заклиная по существующему ID")
    public void testGettingSpellByExistingId(){
        rh.getSpellByExsistingId(EXISTING_ID_OF_SPELL);
    }

    @Test (description = "Получение заклиная по несуществующему ID")
    public void testGettingSpellByNonExistingId(){
        rh.getSpellByNonExsistingId(NON_EXISTING_ID_OF_SPELL);
    }
}
