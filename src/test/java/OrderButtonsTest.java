import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.PageWhoIsScooterFor;
import pageobjects.ScooterPage;

import static org.junit.Assert.assertTrue;

public class OrderButtonsTest extends ScooterTest{

    @Test
    public void orderHeaderButton() {
        ScooterPage Obj1 = new ScooterPage(getDriver());
        PageWhoIsScooterFor Obj2 = new PageWhoIsScooterFor(getDriver());
        Obj1.clickHeaderOrderButton();
        Obj2.waitForLoadPageWhoIsScooterFor();
        assertTrue("Страница 'Для кого самокат' не загрузилась", Obj2.isPageOpened());
    }

    @Test
    public void orderBottomButton() {
        HomePage Obj1 = new HomePage(getDriver());
        PageWhoIsScooterFor Obj2 = new PageWhoIsScooterFor(getDriver());
        Obj1.waitForLoadBottomButton();
        Obj1.clickBottomOrderButton();
        Obj2.waitForLoadPageWhoIsScooterFor();
        assertTrue("Страница 'Для кого самокат' не загрузилась", Obj2.isPageOpened());
    }
}
