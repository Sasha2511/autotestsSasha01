package ua.skillup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OrionRc01OrderCreateSceptreTest {

    WebDriver driver;
    OrionRc1CreateOrder orionRc1CreateOrder;
    OrionRc1OrderPage orionRc1OrderPage;

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
        orionRc1CreateOrder.setOrderParameters(4,0,"2024-12-10","2024-12-20", "Sasha Sasharc1", 2);
        Thread.sleep(2500);
    }

//    @Test
//    public void setTravelers() throws InterruptedException {
//        orionRc1OrderPage = new OrionRc1OrderPage(driver);
//        orionRc1OrderPage.setTravelers();
//        Thread.sleep(5000);
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}