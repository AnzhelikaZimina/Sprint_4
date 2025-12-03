import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.HomePageScooter;
import pageobjects.PageWhoIsScooterFor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScooterOrderTest {
    private WebDriver driver;
@Test
    public void orderScooter() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://qa-scooter.praktikum-services.ru");
    //Главная страница
    HomePageScooter Obj1 = new HomePageScooter(driver);
    PageWhoIsScooterFor Obj2 = new PageWhoIsScooterFor(driver);
    Obj1.homePageClickOrderButton();
    Obj2.waitForLoadPageWhoIsScooterFor();
}
@After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
