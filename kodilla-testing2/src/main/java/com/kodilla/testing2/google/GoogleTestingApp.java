package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GoogleTestingApp {
    public static final String XPATH_INPUT = "/html/body/main/section/form/fieldset/input";
    public static final String XPATH_TEXTAREA = "/html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT_FOR = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form[2]/div/fieldset[2]/select[1]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        webDriver.get("https://binkul.github.io/");

        WebElement searchField = webDriver.findElement(By.xpath(XPATH_INPUT));
        searchField.sendKeys("New robotic task");

        WebElement searchTextArea = webDriver.findElement(By.xpath(XPATH_TEXTAREA));
        searchTextArea.sendKeys("New robotic content");

        while (!webDriver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo = webDriver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);

    }

/*
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
*/
}
