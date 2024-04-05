package site.stellarburgers;

import org.junit.Test;
import site.stellarburgers.pageobject.ConstructorPageObject;

import static org.junit.Assert.assertEquals;

public class ConstructorPageTest extends DriverTest {

    @Test
    public void checkThatClickOnBunsMakeBunsThemeIsActive(){

        ConstructorPageObject constructor = new ConstructorPageObject (driver);

        //перейдем сначало вкладку начинок
        constructor.clickToFillingsMakeItActive();


        // теперь перейдем в раздел булок и убедимся, что он стал активным

        assertEquals("Раздел булок не становится активным",
                 "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect",
                constructor.clickToBunMakeItActive());
    }

    @Test
    public void checkThatClickOnSousesMakeSouseThemeIsActive(){

        ConstructorPageObject constructor = new ConstructorPageObject (driver);

        assertEquals("Раздел соусов не становится активным",
                "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect",
                constructor.clickToSousesMakeItActive());
    }

    @Test
    public void checkThatFillingsOpensFillingsTheme(){

        ConstructorPageObject constructor = new ConstructorPageObject (driver);

        assertEquals("Раздел начинок не становится активным",
                "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect",
                constructor.clickToFillingsMakeItActive());
    }

}
