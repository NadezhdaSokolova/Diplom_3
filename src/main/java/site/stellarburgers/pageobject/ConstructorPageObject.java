package site.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPageObject extends site.stellarburgers.pageobject.DriverClass {
    private final By linkToConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    private final By constructorTopic = By.xpath("//*[@id='root']/div/main/section[1]/h1");
    private final By stellarBurgersLogoLink = By.xpath("//*[@id='root']/div/header/nav/div/a");
    private final By bunsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    private final By sousesTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]");
    private final By fillingsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]");
    private final By fillingsTextName = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[3]");
    private final By bunsTextName = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[1]");
    public ConstructorPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Make click to the constructor topic")
    public void clickToLinkToConstructor(){

        WebElement wb = driver.findElement(linkToConstructor);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
    }

    @Step("Get text from constructor topic")
    public String getTextFromConstructorTopic(){

        WebElement wb = driver.findElement(constructorTopic);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
        return wb.getText();
    }

    @Step("Make click to the main Logo")
    public void clickToStellarBurgersLogoLink(){

        WebElement wb = driver.findElement(stellarBurgersLogoLink);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
    }

    @Step("Make click to the Bun in constructor and get class to check that it's active")
    public String clickToBunMakeItActive(){

        WebElement wb = driver.findElement(bunsTopic);
        wb.click();
        new WebDriverWait(driver, Duration.ofSeconds(200))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsTextName));
        return wb.getAttribute("class");
    }

    @Step("Make click to the souses in constructor and get class to check that it's active")
    public String clickToSousesMakeItActive(){

        WebElement wb = driver.findElement(sousesTopic);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
        return wb.getAttribute("class");
    }

    @Step("Make click to the Fillings in constructor and get class to check that it's active")
    public String clickToFillingsMakeItActive(){

        WebElement wb = driver.findElement(fillingsTopic);
        wb.click();
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsTextName));
        return wb.getAttribute("class");
    }

}
