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

    @AfterClass(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}
