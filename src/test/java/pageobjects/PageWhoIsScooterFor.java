package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PageWhoIsScooterFor extends HomePageScooter{
    private WebDriver driver;
    //Поле ввода имени
    //.//input[@placeholder='* Имя']
    private By firstNameInput = By.xpath(".//input[@placeholder='']");
    //Поле ввода фамилии
    //.//input[@placeholder='* Фамилия']
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    //.//input[@placeholder='* Адрес: куда привезти заказ']
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода станции метро
    //.//input[@placeholder='* Станция метро']
    private By metroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле ввода телефона
    //.//input[@placeholder='* Телефон: на него позвонит курьер']
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Выпадающий список станций метро
    //.//div[@class='select-search__select']
    private By metroDropdown = By.xpath(".//div[@class='select-search__select']");
    // Конкретная станция метро. Подставим название через параметр
    private String metroStationOption = ".//button/div[@class='Order_Text__2broi' and text()='%s']";
    //Кнопка Далее
    //.//button[@class='Button_Button__ra12g Button_Middle__1CSJM']
    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public PageWhoIsScooterFor(WebDriver driver) {
        super(driver);
    }

    public void setFirstNameInput(By firstNameInput) {
        this.firstNameInput = firstNameInput;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetroStation(String stationName) {
        driver.findElement(metroStationInput).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(metroDropdown));
        By stationOption = By.xpath(String.format(metroStationOption, stationName));
        driver.findElement(stationOption).click();
    }

    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void pageWhoIsScooterForClickButton() {
        driver.findElement(buttonNext).click();
    }
    public void waitForLoadPageWhoIsScooterFor() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
    }
}

/*Метод выбора метро для теста:
Кликаю по input выбора метро, жду .//div[@class='select-search__select'] и выбираю метро
.//button/div[@class='Order_Text__2broi' and text()='Преображенская площадь'] - первое
.//button/div[@class='Order_Text__2broi' and text()='Библиотека имени Ленина'] - второе
 */