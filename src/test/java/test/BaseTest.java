package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        if (System.getProperty("browser", "chrome").equals("firefox")) {
            driver = createFirefoxDriver();
        } else {
            driver = createChromeDriver();
        }
        getDriver().get("https://qa-scooter.praktikum-services.ru");
    }

    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    @After
    public void teardown() {
        if (getDriver() != null) {
            driver.quit();
        }
    }

}
