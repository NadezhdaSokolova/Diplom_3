package site.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import site.stellarburgers.pageobject.HomePageObject;
import site.stellarburgers.pageobject.UserPOJO;


public class DriverTest {
        protected WebDriver driver;

    String email = "dnNAA39@yandex.ru";
    String password = "111111";
    String name = "Надежда";
    UserPOJO user = new UserPOJO(email, password, name);

        @Before
        public void setUp(){
            RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
            UserAPI.createUser(user);

            driver = getDriver();
            driver.get(HomePageObject.URL);
        }
        @After
        public void tearDown (){

                try  {
                    UserAPI.makeLogout(UserAPI.getToken(user));
                    UserAPI.deleteUser(UserAPI.getToken(user),user);
                }
                catch (Exception e){
                    System.out.println ("Удалять нечего. Пользователь не прошел авторизацию.");
                }

            driver.quit();
        }
    private WebDriver getDriver() {

        String driverType = System.getenv("BROWSER");
        if (driverType == null) {
            driverType = "chrome";

        }
        switch (driverType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();;
                return new ChromeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
                return new ChromeDriver();

            default:
                throw new IllegalArgumentException("We don't provide this browser in owr code");
        }

        }

}
