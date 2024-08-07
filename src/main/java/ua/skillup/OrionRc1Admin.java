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
        driver.manage().addCookie(new Cookie.Builder("orion_rc_1_session", "eyJpdiI6InpoVEFLVUNWVjJ2cXZ5MDFVUGxzTFE9PSIsInZhbHVlIjoieVZmUzJRcmcxbVh0Rjc4Z0VKWmdpaEM3UncrZ2RjbHZLWTlFblBOM1RJd2dvOVJMdWhnOCswMFhleVg2YVBZdVJPaXhMMUcwYUE3UUxCR2xqZzlZWDNQdHJQNDk1aVMvbW5lYWNuS20wOEYzcVJTdWYxTE1hdWxNTkwrVzRtazgiLCJtYWMiOiJjY2FhZjZmNzQ2ODljODg1YjIzNjUyMDAxNmEzYWY1M2I2NGZhMjc1YWE2MmE0NzQ5ZDkwODJhZDcxNGI4M2VlIiwidGFnIjoiIn0%3D").build());
        driver.get("http://secret:tsdebug@rc1-orion.test.greatvaluevacations.com/admin");
    }
}
