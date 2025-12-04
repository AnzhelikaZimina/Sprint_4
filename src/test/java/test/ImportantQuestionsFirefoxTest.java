package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImportantQuestionsFirefoxTest extends ImportantQuestionsTest {

    public ImportantQuestionsFirefoxTest(String question, String answer) {
        super(question, answer);
    }

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
