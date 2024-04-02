package site.stellarburgers;

import org.junit.Test;
import site.stellarburgers.pageobject.AuthorizationPageObject;
import site.stellarburgers.pageobject.HomePageObject;
import site.stellarburgers.pageobject.PersonalAreaPageObject;

import static org.junit.Assert.assertEquals;

public class PersonalAreaTest extends DriverTest{

    /// тестового пользвателя создать в before с помощью API

    String name = "nadezhda0@yandex.ru";
    String password = "111111";

    @Test
    public void checkPossibilityToGetPersonalArea(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        PersonalAreaPageObject personalArea= new PersonalAreaPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //authorization.clickTheEnterButton(); - перекрыта лругим элементом для клика

        //нажимаем на ссылку "Личный кабинет" и проверяем, что есть заголовок "Профиль",
        // который присутствует на форме авторизованного пользователя

        headPage.waitOrderButtonVisibility();
        headPage.clickOnLinkToPersonalArea();
        assertEquals("Пользователь не прошел авторизацию",
                "В этом разделе вы можете изменить свои персональные данные",
                personalArea.checkInformationBlock());

    }
}
