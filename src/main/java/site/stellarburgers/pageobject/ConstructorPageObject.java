package site.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPageObject extends site.stellarburgers.pageobject.DriverClass {
    private final By linkToConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    private final By constructorTopic = By.xpath("//*[@id='root']/div/main/section[1]/h1");
    private final By stellarBurgersLogoLink = By.xpath("//*[@id='root']/div/header/nav/ul/li[2]/a"); //*[@id="root"]/div/header/nav/ul/li[2]/a/p
    private final By bunsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]/span");
    private final By sousesTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]/span");
    private final By fillingsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]/span");
    public ConstructorPageObject(WebDriver driver) {
        super(driver);
    }


    public void clickToLinkToConstructor(){
        driver.findElement(linkToConstructor).click();
    }

    public String getTextFromConstructorTopic(){
        return driver.findElement(constructorTopic).getText();
    }

    public void clickToStellarBurgersLogoLink(){
        driver.findElement(stellarBurgersLogoLink).click();
    }


}
