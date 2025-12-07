package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPage extends ScooterPage {
    //Поле ввода когда привезти самокат
    //.//input[@placeholder='* Когда привезти самокат']
    private By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Выбранная дата
    //.//div[contains(@class, 'react-datepicker__day') and @tabindex='0']
    private By selectedDeliveryDate = By.xpath(".//div[contains(@class, 'react-datepicker__day') and @tabindex='0']");
    //Поле выбора срока аренды
    //.//div[@class='Dropdown-control']
    private By rentalPeriodPanel = By.xpath(".//div[@class='Dropdown-control']");
    //Выпадающий список выбора срока аренды
    //.//div[@class='Dropdown-menu']
    private By rentalPeriodMenu = By.xpath(".//div[@class='Dropdown-menu']");
    // Конкретный срок аренды. Подставим через параметр
    private String rentalPeriodOption = ".//div[@class='Dropdown-option' and text()='%s']";
    //Чекбокс выбора цвета самоката (черный)
    //.//label[@for='black']
    private By blackColorCheckbox = By.xpath(".//label[@for='black']");
    //Поле ввода комментария
    //.//input[@placeholder='Комментарий для курьера']
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    //.//button[@class='Button_Button__ra12g Button_Middle__1CSJM']
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка "Да"
    //.//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public RentPage(WebDriver driver) {
        super(driver);
    }

    public void setDeliveryDate(String deliveryDate) {
        getDriver().findElement(deliveryDateInput).sendKeys(deliveryDate);
    }

    public void clickSelectedDeliveryDate() {
        getDriver().findElement(selectedDeliveryDate).click();
    }

    public void selectRentalPeriod(String rentalPeriod) {
        getDriver().findElement(rentalPeriodPanel).click();
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(rentalPeriodMenu));
        By rentalOption = By.xpath(String.format(rentalPeriodOption, rentalPeriod));
        getDriver().findElement(rentalOption).click();
    }

    public void clickColorCheckbox() {
        getDriver().findElement(blackColorCheckbox).click();
    }

    public void setComment(String comment) {
        getDriver().findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        getDriver().findElement(orderButton).click();
    }

    public void waitForLoad() {
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
    }

    public void waitForLoadOrderConfirmForm() {
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
    }

    public void clickYesButton() {
        getDriver().findElement(yesButton).click();
    }

    public void waitForLoadStatus() {
        waitForStatusElement();
    }

    private WebElement waitForStatusElement() {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']")));
    }

    public boolean isOrderStatusVisible() {
        return waitForStatusElement().isDisplayed();
    }
}
