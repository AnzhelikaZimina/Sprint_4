package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends ScooterPage {
    //Блок вопроса и ответа
    //.//div[@class='accordion__item' and .//div[@class='accordion__button' and text() = '%s']]
    private String accordionItem = ".//div[@class='accordion__item' and .//div[@class='accordion__button' and text() = '%s']]";
    //Вопрос в блоке вопроса и ответа
    //.//div[@class='accordion__button']
    private By question = By.className("accordion__button");
    //Ответ в блоке вопроса и ответа
    //.//div[@class='accordion__panel']
    private By answer = By.className("accordion__panel");
    //Кнопка заказать нижняя
    //.//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']
    private By bottomButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Выпадающий список в разделе вопросы о важном
    //.//div[@class='accordion']
    private By questionList = By.className("accordion");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoadBottomButton() {
        WebElement element = getDriver().findElement(By.id("root"));
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(bottomButton));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void clickBottomOrderButton() {
        getDriver().findElement(bottomButton).click();
    }

    public void clickAccordionButton(String text) {
        WebElement accordion = getDriver().findElement(questionList);
        WebElement item = accordion.findElement(By.xpath(String.format(accordionItem, text)));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", item);
        item.findElement(question).click();
    }

    public WebElement getAnswerElement(String question) {
        WebElement accordion = getDriver().findElement(questionList);
        WebElement item = accordion.findElement(By.xpath(String.format(accordionItem, question)));
        return item.findElement(answer);
    }

}
