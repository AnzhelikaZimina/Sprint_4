package test;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.WhoIsScooterForPage;
import pageobjects.ScooterPage;

import static org.junit.Assert.assertTrue;

public class OrderButtonsTest extends ScooterTest {

    @Test
    public void orderHeaderButton() {
        ScooterPage scooterPage = new ScooterPage(getDriver());
        WhoIsScooterForPage whoIsScooterForPage = new WhoIsScooterForPage(getDriver());
        scooterPage.clickHeaderOrderButton();
        whoIsScooterForPage.waitForLoadPageWhoIsScooterFor();
        assertTrue("Страница 'Для кого самокат' не загрузилась", whoIsScooterForPage.isPageOpened());
    }

    @Test
    public void orderBottomButton() {
        HomePage homePage = new HomePage(getDriver());
        WhoIsScooterForPage whoIsScooterForPage = new WhoIsScooterForPage(getDriver());
        homePage.waitForLoadBottomButton();
        homePage.clickBottomOrderButton();
        whoIsScooterForPage.waitForLoadPageWhoIsScooterFor();
        assertTrue("Страница 'Для кого самокат' не загрузилась", whoIsScooterForPage.isPageOpened());
    }
}
