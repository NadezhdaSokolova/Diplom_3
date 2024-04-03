package site.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageObject extends site.stellarburgers.pageobject.DriverClass{
    public static final String URL = "https://stellarburgers.nomoreparties.site";
    private final By linkToPersonalArea = By.xpath("//*[@id='root']/div/header/nav/a/p");
    private final By toCreatedOrderButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private final By EnterInAccountButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    public HomePageObject(WebDriver driver) {
        super(driver);
    }


    //кликаем на ссылку 'Личный кабинет'
    @Step("Make click on the link to personal area")
    public void clickOnLinkToPersonalArea(){

        WebElement wb = driver.findElement(linkToPersonalArea);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
    }

    @Step("Make click on the button to enter in account")
    public void clickEnterInAccountButton(){
        driver.findElement(EnterInAccountButton).click();
    }

    @Step("Wait until OrderButton is visible")
    public void waitOrderButtonVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(toCreatedOrderButton));
    }

    @Step("Get text from button provides enter in account")
    public String getTextFromOrderButton(){
        return driver.findElement(toCreatedOrderButton).getText();
    }

}
