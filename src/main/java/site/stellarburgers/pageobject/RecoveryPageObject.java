package site.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPageObject extends site.stellarburgers.pageobject.DriverClass{

    private final By enterButtonFromRecoveryPasswordPage = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    public RecoveryPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickEnterButtonFromRecoveryPasswordPage() {
        driver.findElement(enterButtonFromRecoveryPasswordPage).click();
    }

}
