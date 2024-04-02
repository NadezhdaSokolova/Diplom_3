package site.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AuthorizationPageObject extends site.stellarburgers.pageobject.DriverClass {
    private final By authorizationEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By authorizationPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By enterButton = By.xpath("//*[@id='root']/div/main/div/form/button");

    private final By linkToRegistrationPageFromAuthorizationPage = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private final By passwordRecoveryLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");

    private final By nameTopic = By.xpath("//*[@id='root']/div/main/div/h2");


    public AuthorizationPageObject(WebDriver driver) {
        super(driver);
    }

    public void fillingTheEmailField(String name) {
        driver.findElement(authorizationEmail).sendKeys(name);
    }

    public void fillingThePasswordField(String password) {
        driver.findElement(authorizationPassword).sendKeys(password, Keys.ENTER);
    }

    public void clickTheEnterButton() {
        driver.findElement(authorizationEmail).click();
    }

    public void clickTheLinkToRegistrationPageFromAuthorizationPage() {
        driver.findElement(linkToRegistrationPageFromAuthorizationPage).click();
    }


    public void clickThePasswordRecoveryLink() {
        driver.findElement(passwordRecoveryLink).click();
    }

    public String getTextFromTopicName() {
        return driver.findElement(nameTopic).getText();
    }



}


