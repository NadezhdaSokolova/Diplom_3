import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObject.AuthorizationPageObject;


public class DriverTest {

        protected WebDriver driver;


        @Before

        public void setUp(){

            driver = getDriver();
            driver.get(AuthorizationPageObject.URL);

        }


        @After

        public void tearDown (){
            driver.quit();
        }

        private WebDriver getDriver() {

            String driverType = System.getenv("BROWSER");
            if (driverType == null) {
                driverType = "chrome";

            }
            switch (driverType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();

                default:
                    throw new IllegalArgumentException("We don't provide this browser in owr code");
            }


        }




}
