package PageObject;

import org.openqa.selenium.By;

public class RegistrationPageObject {

    private final By nameField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/div/input");
    private final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    private final By password = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");

    private final By registrationButton = By.xpath("//*[@id='root']/div/main/div/form/button");

    private final By enterLinkInRegistrationForm = By.xpath ("//*[@id='root']/div/main/div/div/p/a");

}
