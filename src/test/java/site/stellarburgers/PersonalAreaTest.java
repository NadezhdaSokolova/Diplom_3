package site.stellarburgers;

import org.junit.Test;
import site.stellarburgers.pageobject.AuthorizationPageObject;
import site.stellarburgers.pageobject.ConstructorPageObject;
import site.stellarburgers.pageobject.HomePageObject;
import site.stellarburgers.pageobject.PersonalAreaPageObject;

import static org.junit.Assert.assertEquals;

public class PersonalAreaTest extends DriverTest{

    @Test
    public void checkPossibilityToGetPersonalArea(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        PersonalAreaPageObject personalArea= new PersonalAreaPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //нажимаем на ссылку "Личный кабинет"

        headPage.waitOrderButtonVisibility();
        headPage.clickOnLinkToPersonalArea();

        // ждем загрузку странички
        personalArea.waitExitButtonVisibility();

        // проверяем, что мы в профиле как зарегистрированный пользователь

        assertEquals("Пользователь не прошел авторизацию",
                "В этом разделе вы можете изменить свои персональные данные",
                personalArea.checkInformationBlock());
    }

    @Test
    public void checkToGoAwayFromPersonalArea(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        PersonalAreaPageObject personalArea= new PersonalAreaPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);


        //нажимаем на ссылку "Личный кабинет"

        headPage.waitOrderButtonVisibility();
        headPage.clickOnLinkToPersonalArea();

        // ждем, когда кнопка выхода станет доступной, ищем кнопку "Выход" и нажимаем на нее
        personalArea.waitExitButtonVisibility();

        personalArea.clickExitButtonFromPersonalArea();
        authorization.waitNameTopicVisibility();

        assertEquals("Пользователь не смог выйти из аккаунта",
                "Вход",
                authorization.getTextFromTopicName());
    }

    @Test
    public void checkToMoveOnConstructorArea(){

        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        ConstructorPageObject constructorPage = new ConstructorPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //нажимаем на ссылку "Личный кабинет"

        headPage.waitOrderButtonVisibility();
        headPage.clickOnLinkToPersonalArea();

        //нажимаем на элемент "Конструктор"
        constructorPage.clickToLinkToConstructor();

        //проверяем наличие элемента "Соберите бургер"
        assertEquals("Пользователь не смог перейти в конструктор",
                "Соберите бургер",
                constructorPage.getTextFromConstructorTopic());
    }

    @Test
    public void checkToMoveOnMainLogo(){

        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        ConstructorPageObject constructorPage = new ConstructorPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //нажимаем на ссылку "Личный кабинет"

        headPage.waitOrderButtonVisibility();
        headPage.clickOnLinkToPersonalArea();

        //нажимаем на элемент "Логотипа"
        constructorPage.clickToStellarBurgersLogoLink();

        //проверяем наличие элемента "Соберите бургер"
        assertEquals("Пользователь не смог перейти на главную страницу",
                "Соберите бургер",
                constructorPage.getTextFromConstructorTopic());
    }

}
