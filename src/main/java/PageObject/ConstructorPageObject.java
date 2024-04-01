package PageObject;

import org.openqa.selenium.By;

public class ConstructorPageObject {
    private final By lintToConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");

    private final By enterInAccountFromConstructorPage = By.xpath("//*[@id='root']/div/main/section[2]/div/button");

    private final By stellarBurgersLogoLink = By.xpath("//*[@id='root']/div/header/nav/div/a/svg");

    private final By bunsTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]/span");

    private final By sousesTopic = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]/span");

    private final By fillings = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]/span");

}
