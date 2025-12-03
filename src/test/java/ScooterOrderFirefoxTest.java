import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScooterOrderFirefoxTest extends ScooterOrderTest {
    public ScooterOrderFirefoxTest(String name, String surname, String address, String metro, String phone, String deliveryDate, String rentalPeriod, String comment) {
        super(name, surname, address, metro, phone, deliveryDate, rentalPeriod, comment);
    }

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
