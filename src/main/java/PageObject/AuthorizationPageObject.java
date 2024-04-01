package PageObject;

import org.openqa.selenium.By;

public class AuthorizationPageObject {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    private final By authorizationEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");

    private final By authorizationPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    private final By enterButton = By.xpath("//*[@id='root']/div/main/div/form/button");

    private final By passwordRecoveryLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");

    private final By enterButtonFromRecoveryPasswordPage = By.xpath("//*[@id='root']/div/main/div/div/p/a");

}
