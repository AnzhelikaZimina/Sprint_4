package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class HomePageScooter {
    private WebDriver driver;
    //Кнопка заказать
    //.//button[@class='Button_Button__ra12g']
    private By buttonOrder = By.className("Button_Button__ra12g");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void homePageClickOrderButton() {
        driver.findElement(buttonOrder).click();
    }

    /*public void waitPageWhoIsScooterFor() { //метод ожидания для следующей формы
        By orderForm = By.xpath(".//div[@class='Order_Content__bmtHS']"); - вынести в переменные
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }*/
}
