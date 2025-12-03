import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class ScooterTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createDriver();
        getDriver().get("https://qa-scooter.praktikum-services.ru");
    }

    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    WebDriver getDriver() {
        return driver;
    }

    @After
    public void teardown() {
        if (getDriver() != null) {
            //driver.quit();
        }
    }

}
