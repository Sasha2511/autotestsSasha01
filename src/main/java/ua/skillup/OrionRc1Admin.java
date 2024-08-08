package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class OrionRc1Admin {

    private final WebDriver driver;
    private final By GET_PACKAGE_QUOTE = By.xpath("//a[text()='getPackageQuote']");


    OrionRc1Admin(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6InVURHQzUVRRSWNtSDdEWnZ1L3JtY0E9PSIsInZhbHVlIjoiOG4xaFNycjNhdHhZQndwUzlYaUNlMEdBYkFxQi9oNnM0bTllZW5idzc5Um5XMjFZcXBUekxDZXhMSUFCalBuOVd4MXlPSy9HZm9NUlRLVEcwL2U3YS9ia2JyTk5mYVAwWFhJRnA4K1B3RlpQL05BOWFUU21SZDh3aThJa1FsS3QiLCJtYWMiOiJhMDM4YjJhNjVmMGE1NGNmNGRkZWQyYjY1N2IxMzc2MjI3NGQ1NDg5M2RjY2NhMjBhZTAzNzIyYmI0OTM2MGI4IiwidGFnIjoiIn0%3D").build());
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin");
    }

    public boolean isOnAdminPage() {
        List<WebElement> getPackageQuote = driver.findElements(GET_PACKAGE_QUOTE);
        return !getPackageQuote.isEmpty();
    }
}
