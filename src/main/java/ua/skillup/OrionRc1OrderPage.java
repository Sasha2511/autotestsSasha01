package ua.skillup;

import org.openqa.selenium.*;
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
            {1, "Garry", "Seaver", "01 Jan 2017", 0},
    };

    public OrionRc1OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin/");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6ImVHem0rWE5jM0NGbHpCVWNIWndNMnc9PSIsInZhbHVlIjoidGx6YjRXNkw1WldpUEZDZWp1MVM5K2JLM0V2NzNjVnFydU5FNWlNMGZVRVVnTHhPS1VMU1JrNnRDRGZhU0hSKzdVMHM3NlBGdzMvaG53QXlJV0VDRWV6bXY1RzlheGlDVU1yWTR2UjU2S0JEMW5sd3BQdlVwOHBRbEEvdjVoamQiLCJtYWMiOiIxMTdkZGViOTZhYTgyMTc3NTU3MDFkOTI0OTI5YmUwMGY2MjNjM2YwNWNkZDY0OGM3NDBlODBmOTkyMDFiZTQyIiwidGFnIjoiIn0%3D").build());
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
        final By BUTTON_SAVE_TRAVELLERS = By.xpath("//button[text()='Save Travelers']");
        By traveler_PREFIX; //= By.xpath("//tbody/tr[1]//select[@class='custom-select traveler__select traveler__select--prefix']");;
        //some changes
        By traveler_NAME; //= By.xpath("//tbody/tr[1]//input[@class='form-control traveler__name-input']");
        By traveler_LASTNAME; //= By.xpath("//tbody/tr[1]/td[5]/input[@class='form-control traveler__name-input']");
        By traveler_DOB; //= By.xpath("//tbody/tr[1]//div[@class='traveler__dob-input']//input");
        By traveler_GENDER;// = By.xpath("//tbody/tr[1]//select[@class='custom-select traveler__select traveler__select--gender']");

        WebElement travelersTab = driver.findElement(TRAVELERS_TAB);
        travelersTab.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstTravelerPrefixDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_TRAVELER_PREFIX));


        for (int i=0; i<=4; i++) {
            String[] row =  getTravelerXpathByLine(i+1);
            traveler_PREFIX = By.xpath(row[0]);
            traveler_NAME = By.xpath(row[1]);
            traveler_LASTNAME = By.xpath(row[2]);
            traveler_DOB = By.xpath(row[3]);
            traveler_GENDER = By.xpath(row[4]);

            WebElement dropdownPrefix = driver.findElement(traveler_PREFIX);
            Select travelerPrefix = new Select(dropdownPrefix);
            travelerPrefix.selectByIndex((int) TRAVELERS[i][0]);


            WebElement inputNameField = driver.findElement(traveler_NAME);
            inputNameField.sendKeys(Keys.CONTROL + "a");
            inputNameField.sendKeys(Keys.DELETE);
            inputNameField.sendKeys((String) TRAVELERS[i][1]);

            WebElement inputLastNameField = driver.findElement(traveler_LASTNAME);
            inputLastNameField.sendKeys(Keys.CONTROL + "a");
            inputLastNameField.sendKeys(Keys.DELETE);
            inputLastNameField.sendKeys((String) TRAVELERS[i][2]);

            WebElement inputDOB = driver.findElement(traveler_DOB);
            inputDOB.sendKeys(Keys.CONTROL + "a");
            inputDOB.sendKeys(Keys.DELETE);
            inputDOB.sendKeys((String) TRAVELERS[i][3]);

            WebElement dropdownGender = driver.findElement(traveler_GENDER);
            Select selectGender = new Select(dropdownGender);
            selectGender.selectByIndex((int) TRAVELERS[i][4]);
        }

        WebElement saveTravelersButton = driver.findElement(BUTTON_SAVE_TRAVELLERS);
        saveTravelersButton.click();

    }


}
