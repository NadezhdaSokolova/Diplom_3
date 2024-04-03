package site.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPageObject extends site.stellarburgers.pageobject.DriverClass {
    private final By authorizationEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By authorizationPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By linkToRegistrationPageFromAuthorizationPage = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private final By passwordRecoveryLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");
    private final By nameTopic = By.xpath("//*[@id='root']/div/main/div/h2");


    public AuthorizationPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Add email name in Email Field")
    public void fillingTheEmailField(String email) {
        driver.findElement(authorizationEmail).sendKeys(email);
    }

    @Step("Add password in Password Field")
    public void fillingThePasswordField(String password) {
        driver.findElement(authorizationPassword).sendKeys(password, Keys.ENTER);
    }

    @Step("Make click to the link on Registration form from Authorization form")
    public void clickTheLinkToRegistrationPageFromAuthorizationPage() {
        driver.findElement(linkToRegistrationPageFromAuthorizationPage).click();
    }

    @Step("Make click to the link on Password recovery form from Authorization form")
    public void clickThePasswordRecoveryLink() {
        driver.findElement(passwordRecoveryLink).click();
    }

    @Step("Wait name topic will be visible")
    public void waitNameTopicVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(nameTopic));
    }

    @Step("Get text from Topic Name")
    public String getTextFromTopicName() {

        WebElement wb = driver.findElement(nameTopic);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("arguments[0].click();", wb);
        return wb.getText();
    }

}


