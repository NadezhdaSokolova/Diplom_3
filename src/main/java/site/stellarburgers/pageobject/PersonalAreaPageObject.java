package site.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPageObject extends site.stellarburgers.pageobject.DriverClass {

    private final By informationBlock = By.xpath("//*[@id='root']/div/main/div/nav/p");

    public PersonalAreaPageObject(WebDriver driver) {
        super(driver);
    }

    public String checkInformationBlock() {
        return driver.findElement(informationBlock).getText();
    }
}
