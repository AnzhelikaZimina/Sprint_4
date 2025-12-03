import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.ScooterPage;
import pageobjects.PageRent;
import pageobjects.PageWhoIsScooterFor;
import io.github.bonigarcia.wdm.WebDriverManager;

import javax.swing.*;
import java.time.Duration;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends ScooterTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String comment;

    public ScooterOrderTest(String name, String surname, String address, String metro, String phone, String deliveryDate, String rentalPeriod, String comment) {
        super();
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Антон", "Антонов", "Адрес 55", "Преображенская площадь", "+79998885555",
                        "05.05.2023", "сутки", "Комментарий 1"},

                {"Мария", "Иванова", "Проспект Мира 10", "Библиотека имени Ленина", "+79998887777",
                        "10.05.2024", "двое суток", "Комментарий 2"},

                {"Илья", "Петров", "Тверская 12", "Арбатская", "+79995554433",
                        "15.05.2025", "трое суток", "Комментарий 3"}
        };
    }

    @Test
    public void orderScooter() {
        //Главная страница
        ScooterPage Obj1 = new ScooterPage(getDriver());
        PageWhoIsScooterFor Obj2 = new PageWhoIsScooterFor(getDriver());
        Obj1.clickHeaderOrderButton();
        Obj2.waitForLoadPageWhoIsScooterFor();
        //Страница для кого самокат
        PageRent Obj3 = new PageRent(getDriver());
        Obj2.setFirstName(name);
        Obj2.setLastName(surname);
        Obj2.setAddress(address);
        Obj2.selectMetroStation(metro);
        Obj2.setPhone(phone);
        Obj2.pageWhoIsScooterForClickButton();
        Obj3.waitForLoadPageRent();
        //Страница деталей аренды
        Obj3.setDeliveryDate(deliveryDate);
        Obj3.clickSelectedDeliveryDate();
        Obj3.selectRentalPeriod(rentalPeriod);
        Obj3.clickColorCheckbox();
        Obj3.setComment(comment);
        Obj3.clickButtonOrder();
        //Окно подтверждения заказа
        Obj3.waitForLoadOrderConfirmForm();
        Obj3.clickYesButton();
        WebElement element  = new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']")));
        assertTrue("Окно подтверждения не открылось", element.isDisplayed());
    }
}
