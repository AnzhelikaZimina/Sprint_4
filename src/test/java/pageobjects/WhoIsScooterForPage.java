package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhoIsScooterForPage extends ScooterPage {
    //Поле ввода имени
    //.//input[@placeholder='* Имя']
    private By firstNameInput = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    //.//input[@placeholder='* Фамилия']
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    //.//input[@placeholder='* Адрес: куда привезти заказ']
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле выбора станции метро
    //.//input[@placeholder='* Станция метро']
    private By metroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    //Выпадающий список станций метро
    //.//div[@class='select-search__select']
    private By metroDropdown = By.xpath(".//div[@class='select-search__select']");
    // Конкретная станция метро. Подставим название через параметр
    private String metroStationOption = ".//button/div[@class='Order_Text__2broi' and text()='%s']";
    //Поле ввода телефона
    //.//input[@placeholder='* Телефон: на него позвонит курьер']
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    //.//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']
    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public WhoIsScooterForPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstName) {
        getDriver().findElement(firstNameInput).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        getDriver().findElement(lastNameInput).sendKeys(lastName);
    }

    public void setAddress(String address) {
        getDriver().findElement(addressInput).sendKeys(address);
    }

    public void selectMetroStation(String stationName) {
        getDriver().findElement(metroStationInput).click();
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(metroDropdown));
        By stationOption = By.xpath(String.format(metroStationOption, stationName));
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(stationOption));
        getDriver().findElement(stationOption).click();
    }

    public void setPhone(String phone) {
        getDriver().findElement(phoneInput).sendKeys(phone);
    }

    public void pageWhoIsScooterForClickButton() {
        getDriver().findElement(buttonNext).click();
    }

    public void waitForLoadPageWhoIsScooterFor() {
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
    }

    public boolean isPageOpened() {
        return getDriver().findElement(firstNameInput).isDisplayed();
    }
}
