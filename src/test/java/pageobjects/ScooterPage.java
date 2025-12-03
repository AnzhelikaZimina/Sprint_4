package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ScooterPage {
    private WebDriver driver;

    //Кнопка заказать верхняя
    //.//button[@class='Button_Button__ra12g']
    private By HeaderButton = By.className("Button_Button__ra12g");

    public ScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHeaderOrderButton() {
        driver.findElement(HeaderButton).click();
    }

    WebDriver getDriver() {
        return driver;
    }
}
