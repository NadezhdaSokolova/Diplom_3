package site.stellarburgers;

import org.junit.Test;
import site.stellarburgers.pageobject.AuthorizationPageObject;
import site.stellarburgers.pageobject.HomePageObject;
import site.stellarburgers.pageobject.RecoveryPageObject;
import site.stellarburgers.pageobject.RegistrationPageObject;
import static org.junit.Assert.assertEquals;

public class AuthorizationTest extends DriverTest{

    @Test
    public void checkLoginViaEnterInAccountButton(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);

        //нажимаем на кнопку "Войти в аккаунт" и авторизуемся
        headPage.clickEnterInAccountButton();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //проверяем, что после авторизации на главной странице появляется кнопка "Оформить заказ"

        headPage.waitOrderButtonVisibility();
        assertEquals("Пользователь не прошел авторизацию",
                "Оформить заказ",
                headPage.getTextFromOrderButton());
    }

    @Test
    public void checkLoginViaPersonalArea(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();
        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //проверяем, что после авторизации на главной странице появляется кнопка "Оформить заказ"

        headPage.waitOrderButtonVisibility();
        assertEquals("Пользователь не прошел авторизацию",
                "Оформить заказ",
                headPage.getTextFromOrderButton());
    }

    @Test
    public void checkLoginViaRegistrationForm(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        RegistrationPageObject registrationForm = new RegistrationPageObject(driver);

        //нажимаем на ссылку "Личный кабинет"

        headPage.clickOnLinkToPersonalArea();
        // на форме авторизации нажимаем линку-переход к форме регистрации

        authorization.clickTheLinkToRegistrationPageFromAuthorizationPage();

        // переход c формы регистрации на форму авторизации по линке "Войти" и авторизуемся
        registrationForm.clickToLinkInRegistrationForm();

        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //проверяем, что после авторизации на главной странице появляется кнопка "Оформить заказ"

        headPage.waitOrderButtonVisibility();
        assertEquals("Пользователь не прошел авторизацию",
                "Оформить заказ",
                headPage.getTextFromOrderButton());
    }

    @Test
    public void checkLoginViaRecoveryPasswordForm(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        RecoveryPageObject recoveryPage = new RecoveryPageObject(driver);

        //нажимаем на ссылку "Личный кабинет"

        headPage.clickOnLinkToPersonalArea();
        // на форме авторизации нажимаем линку-переход к форме "Восстановить пароль"

        authorization.clickThePasswordRecoveryLink();

        // переход c формы восстановления пароля на форму авторизации по линке "Войти"
        recoveryPage.clickEnterButtonFromRecoveryPasswordPage();

        authorization.fillingTheEmailField(email);
        authorization.fillingThePasswordField(password);

        //проверяем, что после авторизации на главной странице появляется кнопка "Оформить заказ"

        headPage.waitOrderButtonVisibility();
        assertEquals("Пользователь не прошел авторизацию",
                "Оформить заказ",
                headPage.getTextFromOrderButton());
    }

}
