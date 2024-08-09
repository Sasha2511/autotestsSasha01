package ua.skillup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class OrionRc1OrderGVV {
    WebDriver driver;
    OrionRc1Admin orionRc1Admin;

    @BeforeClass
    public void admin() {
        driver = new ChromeDriver();
        orionRc1Admin = new OrionRc1Admin(driver);
        orionRc1Admin.open();
    }

    @Test
    public void openOrder() throws InterruptedException {
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
    }

    @Test
    public void onOrderPage() {
        assertTrue(orionRc1Admin.isOnOrderPage());
    }

    @Test
    public void clickCreateButton() {
        orionRc1Admin.clickCreateButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
