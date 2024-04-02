package site.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPageObject extends site.stellarburgers.pageobject.DriverClass {

    private final By informationBlock = By.xpath("//*[@id='root']/div/main/div/nav/p");

    private final By exitButton = By.xpath("//*[@id='root']/div/main/div/nav/ul/li[3]/button");

    public PersonalAreaPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickExitButtonFromPersonalArea() {
        driver.findElement(exitButton).click();
    }

    public String checkInformationBlock() {
        return driver.findElement(informationBlock).getText();
    }


}
