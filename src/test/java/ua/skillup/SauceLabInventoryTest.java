package ua.skillup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class SauceLabInventoryTest {
    WebDriver driver;
    InventoryPage inventoryPage;
    OrionRc1Admin orionRc1Admin;

    @BeforeClass(enabled = false)
    public void setUp() {
        driver = new ChromeDriver();
        inventoryPage = new InventoryPage(driver);
        inventoryPage.open();
    }

    @Test(enabled = false)
    public void onInventoryPage() {
        assertTrue(inventoryPage.isOnInventoryPage());
    }

    @DataProvider//(parallel = true)
    public Object[] filter() {
        return inventoryPage.sortListValue;
    }

    @Test(dataProvider = "filter", enabled = false )
    public void testFilters(String filter) {
        inventoryPage.sortList(filter);
        assertTrue(inventoryPage.isSorted(filter));
    }

    @BeforeClass
    public void admin() {
        driver = new ChromeDriver();
        orionRc1Admin = new OrionRc1Admin(driver);
        orionRc1Admin.open();
    }

    @Test
    public void openAdmin() throws InterruptedException {
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
    }

    @Test
    public void onAdminPage() {
        assertTrue(orionRc1Admin.isOnAdminPage());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
