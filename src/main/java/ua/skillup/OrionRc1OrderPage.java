package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrionRc1OrderPage {
    private final By TRAVELERS_TAB = By.xpath("//a[contains(text(),'Travelers')]");
    private final By ITINERARY_TAB = By.xpath("//a[contains(text(),'Itinerary')]");
    private final WebDriver driver;

    private final Object[][] TRAVELERS = {
            {1, "Tom", "Seaver", "01 Jan 1981", 1},
            {2, "Emma", "Seaver", "01 Jan 1982", 2},
            {1, "David", "Seaver", "01 Jan 1983", 1},
            {2, "Sofy", "Seaver", "01 Jan 2016", 2},
            {1, "David", "Seaver", "01 Jan 2017", 1},
    };

    public OrionRc1OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6ImpFUTJPcW5OU0x3aUdZRWhGSytVT3c9PSIsInZhbHVlIjoiVXRTcHhoWXdpNmlxdHFlSEk3WDlZeCtqWUprRDVhRkxVbCtROUV0TVNxZ1NPclZ2R1hrS0dIL1J1SDBNV1BGeEQ1aTVjMzNyUVZML3NNNENJRVM1TDg0bmd5cE9wWUdteVkrUFJBdUV3bU5lWDVlb3dCVXg2VDZHQ0J1TzNSYWUiLCJtYWMiOiJjOGVkODRhNjAxYzQyYjJhY2JlMDM4ZmZlYmQ2ZDg3NTVjNTI1OWQzMWFkODkxOTg1MDAwOWRkODViYWYyMjQ1IiwidGFnIjoiIn0%3D").build());
        driver.get("http://rc1-orion.test.greatvaluevacations.com/admin/order/DEVG315#summary");
    }

    public void setTravelers() {

        final By FIRST_TRAVELER_PREFIX = By.xpath("//tbody/tr[1]//select[@class='custom-select traveler__select traveler__select--prefix']");


        WebElement travelersTab = driver.findElement(TRAVELERS_TAB);
        travelersTab.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstTravelerPrefixDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_TRAVELER_PREFIX));
        Select firstTravelerPrefix = new Select(firstTravelerPrefixDropdown);

        firstTravelerPrefix.selectByIndex(2);

    }
}
