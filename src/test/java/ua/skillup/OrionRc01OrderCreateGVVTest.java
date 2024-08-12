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
        Thread.sleep(2500);
    }

    @Test(enabled = false)
    public void onNewOrderPage() {
        assertTrue(orionRc1CreateOrder.isOnNewOrderPage());
    }

    @Test
    public void isGVVIsSet() {
        assertTrue(orionRc1CreateOrder.isGVVSelected());
    }

    @Test
    public void setParameters() throws InterruptedException {
        orionRc1CreateOrder.setOrderParameters(3,2,"2024-11-20","2024-11-27");
        Thread.sleep(2500);
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
