package site.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    //кликаем на ссылку "Личный кабинет"
    public void clickOnLinkToPersonalArea(){
        driver.findElement(linkToPersonalArea).click();

    }

    public void clickEnterInAccountButton(){
        driver.findElement(EnterInAccountButton).click();
    }

    public void waitOrderButtonVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(toCreatedOrderButton));
    }

    public String getTextFromOrderButton(){
        return driver.findElement(toCreatedOrderButton).getText();

    }

}
