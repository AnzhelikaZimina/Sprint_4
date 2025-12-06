package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.RentPage;
import pageobjects.WhoIsScooterForPage;
import pageobjects.ScooterPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends BaseTest {
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
        ScooterPage scooterPage = new ScooterPage(getDriver());
        WhoIsScooterForPage whoIsScooterForPage = new WhoIsScooterForPage(getDriver());
        scooterPage.clickHeaderOrderButton();
        whoIsScooterForPage.waitForLoadPageWhoIsScooterFor();
        //Страница для кого самокат
        RentPage rentPage = new RentPage(getDriver());
        whoIsScooterForPage.setFirstName(name);
        whoIsScooterForPage.setLastName(surname);
        whoIsScooterForPage.setAddress(address);
        whoIsScooterForPage.selectMetroStation(metro);
        whoIsScooterForPage.setPhone(phone);
        whoIsScooterForPage.pageWhoIsScooterForClickButton();
        rentPage.waitForLoad();
        //Страница деталей аренды
        rentPage.setDeliveryDate(deliveryDate);
        rentPage.clickSelectedDeliveryDate();
        rentPage.selectRentalPeriod(rentalPeriod);
        rentPage.clickColorCheckbox();
        rentPage.setComment(comment);
        rentPage.clickOrderButton();
        //Окно подтверждения заказа
        rentPage.waitForLoadOrderConfirmForm();
        rentPage.clickYesButton();
        WebElement element  = new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']")));
        assertTrue("Окно подтверждения не открылось", element.isDisplayed());
    }
}
