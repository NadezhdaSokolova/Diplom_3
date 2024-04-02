package site.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPageObject extends site.stellarburgers.pageobject.DriverClass {
    private final By linkToConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    private final By constructorTopic = By.xpath("//*[@id='root']/div/main/section[1]/h1");
    private final By stellarBurgersLogoLink = By.xpath("//*[@id='root']/div/header/nav/div/a/"); //*[@id="root"]/div/header/nav/div/a
    private final By bunsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]/span");
    private final By sousesTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]/span");
    private final By fillingsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]/span");

    private final By bunsTextName = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[1]");

    private final By sousesTextName = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[2])"); //*[@id="root"]/div/main/section[1]/div[2]/h2[2]

    private final By fillingsTextName = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[3]");

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

    @Step("Make click to the Bun in constructor")
    public void clickToBun(){

        WebElement wb = driver.findElement(bunsTopic);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
    }

    @Step("Make click to the Souses in constructor")
    public void clickToSouses(){

        WebElement wb = driver.findElement(sousesTopic);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
    }

    @Step("Make click to the Fillings in constructor")
    public void clickToFillings(){

        WebElement wb = driver.findElement(fillingsTopic);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
    }

    @Step("Get text from the buns topic")
    public String getTextFromBuns(){

        WebElement wb = driver.findElement(bunsTextName);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
        return wb.getText();
    }

    @Step("Get text from the souses topic")
    public String getTextFromSouses(){

        WebElement wb = driver.findElement(sousesTextName);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
        return wb.getText();
    }

    @Step("Get text from the fillings topic")
    public String getTextFromFillings(){

        WebElement wb = driver.findElement(fillingsTextName);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", wb);
        return wb.getText();

    }


}
