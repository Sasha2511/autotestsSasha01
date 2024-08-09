package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class OrionRc1CreateOrder {
    private final By NEW_ORDER_TITLE = By.xpath("//span[contains(text(), 'New Order')]");
    private final By BRAND_SELECTOR = By.xpath("//select[@name='brandId']");
    private final By ADULTS_QUANTITY = By.xpath("//input[@name='adultsCount']");
    private final By CHILDREN_QUANTITY = By.xpath("//input[@name='childrenCount']");
    private final By START_DATE = By.xpath("//input[@name='startDate']");
    private final By END_DATE = By.xpath("//input[@name='endDate']");
    private final By CREATE_BUTTON = By.xpath("//button[@class='btn btn-primary']");

    private final WebDriver driver;

    public OrionRc1CreateOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/order/create");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6ImZCdnc4KzNSZGdTNEorQzdJV2FGd1E9PSIsInZhbHVlIjoiSGx2dU1IOUlkNWRnL1J6UGs2akQwMlZkT2phT0FQWGNFZlgzR3NMTW5oZ2lQcFFRMWtDZUFxU3UvdkhsQW4zUUFEOCtJeFJDUmVqOXEyTHVUVzl0N0txak1semhCMHpMSmJ0Qk5JckJuSnBsTzVERWhWRjFXeVpqV0VIcUNRVVkiLCJtYWMiOiJjMzU5NTE3YzNjMWZhYzYwNzllYmEwM2UyOTE2OTFiNjlhNGRlZjAyM2FiNzFlN2ZlMGRjYzU5NzY4NjJjNzZkIiwidGFnIjoiIn0%3D").build());
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/order/create");
    }

    public boolean isOnNewOrderPage() {
        List<WebElement> newOrderTitle = driver.findElements(NEW_ORDER_TITLE);
        return !newOrderTitle.isEmpty();
    }

    public boolean isGVVSelected() {
        WebElement selectElement = driver.findElement(BRAND_SELECTOR);
        Select select = new Select(selectElement);
        String actualSelectedValue = select.getFirstSelectedOption().getText();
        String expectedSelectedValue = "GVV";
        return actualSelectedValue.equals(expectedSelectedValue);
    }

    public void setOrderParameters(Integer adults, Integer children, String startDate, String endDate) {
        WebElement adultsQuantity = driver.findElement(ADULTS_QUANTITY);
        WebElement childrenQuantity = driver.findElement(CHILDREN_QUANTITY);
        WebElement startDateInput = driver.findElement(START_DATE);
        WebElement endDateInput = driver.findElement(END_DATE);
        WebElement createButton = driver.findElement(CREATE_BUTTON);

        adultsQuantity.sendKeys(adults.toString());
        childrenQuantity.sendKeys(children.toString());
        startDateInput.sendKeys(startDate);
        endDateInput.sendKeys(endDate);
        createButton.click();
    }

}