package ua.skillup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {
    private final By ITEM_NAMES = By.xpath("//*[@data-test='inventory-item-name']");
    private final By PRICE_ITEMS = By.cssSelector("[data-test=\"inventory-item-price\"]");
    private final By SORT_LIST = By.xpath("//*[@data-test='product-sort-container']");
    private final By SHOPPING_CART = By.cssSelector("[data-test=\"inventory-item-price\"]");

    public final String[] sortListValue = {"Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"};

   // private List<WebElement> itemNames = ITEM_NAMES;

    private final WebDriver driver;

    InventoryPage(WebDriver driver) {
        this.driver = driver;
    }



    public void open(){
      driver.get("https://www.saucedemo.com/");
      driver.manage().addCookie(new Cookie.Builder("session-username", "standard_user").build());
      driver.get("https://www.saucedemo.com/inventory.html");
    }

    public boolean isOnInventoryPage() {
        List<WebElement> shoppingCart = driver.findElements(SHOPPING_CART);
        return !shoppingCart.isEmpty();
    }

    public void sortList (String string) {
        WebElement sortList = driver.findElement(SORT_LIST);
        Select select = new Select(sortList);
        select.selectByVisibleText(string);
    }

    private boolean isSortedByName(String filter) {
        List<WebElement> productNames = driver.findElements(ITEM_NAMES);
        List<String> names = productNames.stream()
                .map(WebElement::getText)
                .toList();

        List<String> sortedNames;
        if (filter.contains("A to Z")) {
            sortedNames = names.stream().sorted().collect(Collectors.toList());
        } else if (filter.contains("Z to A")) {
            sortedNames = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Unsupported filter: " + filter);
        }

        return names.equals(sortedNames);

    }


    private boolean isSortedByPrice(String filter) {
        List<WebElement> productPrices = driver.findElements(PRICE_ITEMS);
        List<Double> prices = productPrices.stream()
                .map(element -> Double.parseDouble(element.getText().substring(1)))
                .toList();

        List<Double> sortedPrices;
        if (filter.contains("low to high")) {
            sortedPrices = prices.stream().sorted().collect(Collectors.toList());
        } else if (filter.contains("high to low")) {
            sortedPrices = prices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Unsupported filter: " + filter);
        }

        return prices.equals(sortedPrices);
    }

    public boolean isSorted(String filter) {
        if (filter.contains("Name")) {
            return isSortedByName(filter);
        } else if (filter.contains("Price")) {
            return isSortedByPrice(filter);
        } else {
            throw new IllegalArgumentException("Unsupported filter: " + filter);
        }
    }



}
