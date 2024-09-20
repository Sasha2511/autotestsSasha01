package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class OrionRc1CreateOrder {
    private final By NEW_ORDER_TITLE = By.xpath("//span[contains(text(), 'New Order')]");
    private final By BRAND_SELECTOR = By.xpath("//select[@name='brandId']");
    private final By ADULTS_QUANTITY = By.xpath("//input[@name='adultsCount']");
    private final By CHILDREN_QUANTITY = By.xpath("//input[@name='childrenCount']");
    private final By START_DATE = By.xpath("//input[@name='startDate']");
    private final By END_DATE = By.xpath("//input[@name='endDate']");
    private final By CREATE_BUTTON = By.xpath("//button[@class='btn btn-primary']");
    private final By TRAVEL_AGENT = By.xpath("//label[text()='Travel Agent']/following-sibling::div");

    private final WebDriver driver;

    public OrionRc1CreateOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/order/create");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6InJvcHZFMDJEbktIdkNWa1pmbGZ2K3c9PSIsInZhbHVlIjoia3NWeGpHZlBxeFNSS05DOFF1SzVmM1NBd3Y5OHBnWDBBM0ttdDZ6WFhZUk5GcnUxd1dPcExoQ0wxZ1FKeHIrN25MOGpwS2wyUlhQOW1wcDFKclViRy9MUXVxS2JDZVNFcUZxWFpsNENtb3dRN1ZWVTlEcmc3TS9aTUd3cmZsVjIiLCJtYWMiOiIzODEzMTdlM2U4OWNiNjhjODgxZDE2ZTAzMTdjZGVhZTBiNzliNzYwOWI0YzFiMTVmNDI5NjM2YWU1YTM1OWIyIiwidGFnIjoiIn0%3D").build());
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
    // for GVV
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
    // for Sceptre
    public void setOrderParameters(Integer adults, Integer children, String startDate, String endDate, String agent , Integer brand) {
        WebElement adultsQuantity = driver.findElement(ADULTS_QUANTITY);
        WebElement childrenQuantity = driver.findElement(CHILDREN_QUANTITY);
        WebElement startDateInput = driver.findElement(START_DATE);
        WebElement endDateInput = driver.findElement(END_DATE);
        WebElement createButton = driver.findElement(CREATE_BUTTON);
        WebElement setAgent = driver.findElement(TRAVEL_AGENT);
        WebElement setBrand = driver.findElement(BRAND_SELECTOR);

        Select dropdownBrand = new Select(setBrand);

        dropdownBrand.selectByIndex(brand);
        adultsQuantity.sendKeys(adults.toString());
        childrenQuantity.sendKeys(children.toString());
        startDateInput.sendKeys(startDate);
        endDateInput.sendKeys(endDate);
        setAgent.click();
        setAgent.sendKeys(agent);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class,'react-select__option') and text()='" + agent + "']")));


        dropdownOption.click();

        //createButton.click();
    }

}
