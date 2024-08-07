package ua.skillup;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


public class OrionRc1Admin {

    private final WebDriver driver;

    OrionRc1Admin(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin");
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6IloxbFA0QW5DMmtYZFcwek9sOTIrT0E9PSIsInZhbHVlIjoiQzRGa1VsV2NFdkZtNEVCdmFFVDl5WFF5VFpPWGpyZElBaG9xTVdYeEZ5WUhGL0VlQzdOanpaSEw2dGFickRLb3Iva0FWclUxeWhWd3dvTkVQWVZUMmU1eTNqcUtqb1kwTXh3WFFqbDU0V0xwbzB5S1JRdW8yc1BtRXVsWUxUZmgiLCJtYWMiOiIzMDQ0YzJiMzZkMWM3OTg2NWQ1ZjU5YTM2ODQ4NDRmM2FhNTIwMzliMzE3ZDg0NjhkMTU5MDZmYTBjYzEzNzMxIiwidGFnIjoiIn0%3D").build());
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin");
    }
}
