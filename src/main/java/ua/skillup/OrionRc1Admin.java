package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;


public class OrionRc1Admin {

    private final WebDriver driver;
    private final By GET_PACKAGE_QUOTE = By.xpath("//a[text()='getPackageQuote']");
    private final By ORDER_TITLE = By.xpath("//span[text()='Orders']");
    private final By CRETE_BUTTON = By.xpath("//a[contains(@class, 'btn-outline-success')]");

    OrionRc1Admin(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6Im5LRk5IVnU3N05FQUxCTEozMWQxQ2c9PSIsInZhbHVlIjoibDRxcFVyR1Q2NWNaVFJQRzdIMEVYay9KNEhRR3dKNFdGUFpCZGwyaDZ5OFNBTXlvN29oWFU1bUxpblZPcFNOcFNKUzEyTmZ6VW1US0dQYmN1aXpKZXRmL0I3VWQzWXhpVHRCRlNZckJ6V2dyN1o4L2JnUStZTTNQOGo3cmJtQTUiLCJtYWMiOiI3MTczZjUwZWJhMjEyOWRlYzZiNGYxNTk4MDMxNzNmMjU1NTg0YmM3ODk1YjYxOGI1N2JhOTU1MDE2NDdkMzg0IiwidGFnIjoiIn0%3D").build());
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/order");
    }

    public boolean isOnOrderPage() {
        List<WebElement> getPackageQuote = driver.findElements(ORDER_TITLE);
        return !getPackageQuote.isEmpty();
    }

    public void clickCreateButton() {
        WebElement button = driver.findElement(CRETE_BUTTON);
        button.click();
    }
}
