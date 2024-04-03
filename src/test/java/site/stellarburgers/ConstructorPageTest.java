package site.stellarburgers;

import org.junit.Test;
import site.stellarburgers.pageobject.ConstructorPageObject;

import static org.junit.Assert.assertEquals;

public class ConstructorPageTest extends DriverTest {

    @Test
    public void checkThatBunsOpensBunsTheme(){

        ConstructorPageObject constructor = new ConstructorPageObject (driver);

        //нажимаем на раздел "Булки"
        constructor.clickToBun();

        //проверяем, что открылся раздел булок
        assertEquals("Раздел булок не отобразился",
                "Булки",
                constructor.getTextFromBuns());
    }

    @Test
    public void checkThatSousesOpensSousesTheme(){

        ConstructorPageObject constructor = new ConstructorPageObject (driver);

        //нажимаем на раздел "Соусы"
        constructor.clickToSouses();


        //проверяем, что открылся раздел соусов

        assertEquals("Раздел соусов не отобразился",
                "Соусы",
                constructor.getTextFromSouses());
    }

    @Test
    public void checkThatFillingsOpensFillingsTheme(){

        ConstructorPageObject constructor = new ConstructorPageObject (driver);

        //нажимаем на раздел "Начинки"
        constructor.clickToFillings();

        //проверяем, что открылся раздел начинок

        assertEquals("Раздел начинок не отобразился",
                "Начинки",
                constructor.getTextFromFillings());
    }





}
