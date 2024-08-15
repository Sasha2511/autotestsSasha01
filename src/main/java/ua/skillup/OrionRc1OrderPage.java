package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v124.input.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrionRc1OrderPage {
    private final By TRAVELERS_TAB = By.xpath("//a[contains(text(),'Travelers')]");
    private final By ITINERARY_TAB = By.xpath("//a[contains(text(),'Itinerary')]");
    private final WebDriver driver;

    private final Object[][] TRAVELERS = {
            {1, "Tom", "Seaver", "01 Jan 1981", 0},
            {2, "Emma", "Seaver", "01 Jan 1982", 1},
            {1, "David", "Seaver", "01 Jan 1983", 0},
            {2, "Sofy", "Seaver", "01 Jan 2016", 1},
            {1, "David", "Seaver", "01 Jan 2017", 0},
    };

    public OrionRc1OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6IlpDMEVYbVNKZDR1by80bEhXSEpxa1E9PSIsInZhbHVlIjoiTGFJeTBSWDJjelk5SSt5RzVibzByMkNsc2FDUk1lQUhISlF0UGt1c0RlZEoxUGszNlg4WG9sMFlGZ0tQTzFqN3RMK2hPRkZ6eFRERUhoOFVwZFJDMDNiVm5FUUR1akFnY3R1RzFmVkpmd2FqdGdvRk4yajhIZVpsYkQvd1NVd1EiLCJtYWMiOiJjNGQ3YzAyM2RhZjJjYmJkZmU4Y2U0OThmMzcyYzdlMmIyMDdhY2Q3ODI5YjcyNjhjNjE3YTQ2N2JhYmM1ZWZiIiwidGFnIjoiIn0%3D").build());
        driver.get("http://rc1-orion.test.greatvaluevacations.com/admin/order/DEVG315#summary");
    }

    private String[] getTravelerXpathByLine(int n) {
        String[] travelerLineArray;
        travelerLineArray = new String[]{
                "//tbody/tr[" + n + "]//select[@class='custom-select traveler__select traveler__select--prefix']",
                "//tbody/tr[" + n + "]//input[@class='form-control traveler__name-input']",
                "//tbody/tr[" + n + "]/td[5]/input[@class='form-control traveler__name-input']",
                "//tbody/tr[" + n + "]//div[@class='traveler__dob-input']//input",
                "//tbody/tr[" + n + "]//select[@class='custom-select traveler__select traveler__select--gender']"
        };
        return travelerLineArray;
    }

    public void setTravelers() {

        final By FIRST_TRAVELER_PREFIX = By.xpath("//tbody/tr[1]//select[@class='custom-select traveler__select traveler__select--prefix']");

        By traveler_PREFIX;
        By traveler_NAME;
        By traveler_LASTNAME;
        By traveler_DOB;
        By traveler_GENDER;

        WebElement travelersTab = driver.findElement(TRAVELERS_TAB);
        travelersTab.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstTravelerPrefixDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_TRAVELER_PREFIX));
        Select firstTravelerPrefix = new Select(firstTravelerPrefixDropdown);

        firstTravelerPrefix.selectByIndex(2);

     /*   for (int i=0; i<=4; i++) {
            String[] line =  getTravelerXpathByLine(i+1);
            traveler_PREFIX = By.xpath(line[0]);
            traveler_NAME = By.xpath(line[1]);


            Select travelerPrefix = new Select((WebElement) traveler_PREFIX);
           // WebElement inputName = driver.findElement(traveler_NAME);

            travelerPrefix.selectByIndex((int) TRAVELERS[i][0]);
            //inputName.sendKeys((String) TRAVELERS[i][1]);
        }


      */

    }
}
