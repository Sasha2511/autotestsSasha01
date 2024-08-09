package ua.skillup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OrionRc01OrderCreateGVVTest {

    WebDriver driver;
    OrionRc1CreateOrder orionRc1CreateOrder;

    @BeforeClass
    public void admin() {
        driver = new ChromeDriver();
        orionRc1CreateOrder = new OrionRc1CreateOrder(driver);
        orionRc1CreateOrder.open();
    }

    @Test
    public void openOrder() throws InterruptedException {
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
    }

    @Test
    public void onNewOrderPage() {
        assertTrue(orionRc1CreateOrder.isOnNewOrderPage());
    }

    @Test
    public void isGVVIsSet() {
        assertTrue(orionRc1CreateOrder.isGVVSelected());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
