package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.google.com");

        WebElement searchField = webDriver.findElement(By.name(SEARCHFIELD));
//        Actions actions = new Actions(webDriver);
//        actions.moveToElement(searchField).click();
//        actions.sendKeys("Kodilla");
//        actions.perform();

        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
