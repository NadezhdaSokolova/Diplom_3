package site.stellarburgers;

import org.junit.Test;
import site.stellarburgers.pageobject.AuthorizationPageObject;
import site.stellarburgers.pageobject.HomePageObject;
import site.stellarburgers.pageobject.RegistrationPageObject;
import site.stellarburgers.pageobject.UserPOJO;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends DriverTest {

    String emailReg = "1oQRtq4@yandex.ru";
    String emailIncReg = "YYYYYYYY3@yandex.ru";
    String passwordReg = "111111";
    String nameReg = "Надежда";
    UserPOJO userReg = new UserPOJO(emailReg, passwordReg, nameReg);
    String incorrectPasswordReg = "00000";


    @Test
    public void checkRegistrationSuccessfully(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        RegistrationPageObject registration = new RegistrationPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();

        //нажимаем на ссылку "Зарегистрироваться"
        authorization.clickTheLinkToRegistrationPageFromAuthorizationPage();

        //заполняем поля формы
        registration.emailFieldFillingThroughRegistration(emailReg);
        registration.nameFieldFillingThroughRegistration(nameReg);
        registration.passwordFieldFillingThroughRegistration(passwordReg);
        registration.clickRegistrationButton();

        //проверяем, что после регистрации попадаем на  страницу авторизации с названием блока "Вход"

        authorization.waitNameTopicVisibility();
        assertEquals("Пользователь не прошел авторизацию",
                "Забыли пароль? Восстановить пароль",
                authorization.getTextFromQuestionOnAuthorizationForm());

        // авторизуемся

        authorization.fillingTheEmailField(emailReg);
        authorization.fillingThePasswordField(passwordReg);


        // и удаляем пользователя
        UserAPI.makeLogout(UserAPI.getToken(userReg));
        UserAPI.deleteUser(UserAPI.getToken(userReg),userReg);
    }

    @Test
    public void checkErrorMessageIfPasswordIncorrect(){
        HomePageObject headPage = new HomePageObject (driver);
        AuthorizationPageObject authorization = new AuthorizationPageObject (driver);
        RegistrationPageObject registration = new RegistrationPageObject(driver);

        //нажимаем на ссылку "Личный кабинет" и авторизуемся
        headPage.clickOnLinkToPersonalArea();

        //нажимаем на ссылку "Зарегистрироваться"
        authorization.clickTheLinkToRegistrationPageFromAuthorizationPage();

        //заполняем поля формы
        registration.emailFieldFillingThroughRegistration(emailIncReg);
        registration.nameFieldFillingThroughRegistration(nameReg);
        registration.passwordFieldFillingThroughRegistration(incorrectPasswordReg);
        registration.clickRegistrationButton();

        //проверяем, сообщение об ошибке при пароле менее 6 символов


        assertEquals("Не выдержано требование к минимальности пароля",
                "Некорректный пароль",
                registration.getErrorMessageWhenIncorrectPassword());
    }

}
