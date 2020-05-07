package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class FacebookTestingApp {
    private static final int BIRTH_YEAR = 1970;
    private static final String XPATH_DAY_SELECT = "//div[contains(@class, \"58mq\")]/div[2]/span/span/select[1]";
    private static final String XPATH_MONTH_SELECT = "//div[contains(@class, \"58mq\")]/div[2]/span/span/select[2]";
    private static final String XPATH_YEAR_SELECT = "//div[contains(@class, \"58mq\")]/div[2]/span/span/select[3]";
    private static final String XPATH_RADIO_BUTTON = "//div[contains(@class, \"5wa2\")]/span/span[2]/input[1]";
    private static final String XPATH_NAME_TEXT = "//div[contains(@class, \"58mh\")]/div[1]/div/div/input[1]";
    private static final String XPATH_LASTNAME_TEXT = "//div[contains(@class, \"58mh\")]/div[2]/div/div/input[1]";

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int presentYear = date.getYear();
        int yearPos = presentYear - BIRTH_YEAR + 1;

        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com");

        WebElement selectComboDay = webDriver.findElement(By.xpath(XPATH_DAY_SELECT));
        Select selectBoardDay = new Select(selectComboDay);
        selectBoardDay.selectByIndex(4);

        WebElement selectComboMonth = webDriver.findElement(By.xpath(XPATH_MONTH_SELECT));
        Select selectBoardMonth = new Select(selectComboMonth);
        selectBoardMonth.selectByIndex(2);

        WebElement selectComboYear = webDriver.findElement(By.xpath(XPATH_YEAR_SELECT));
        Select selectBoardYear = new Select(selectComboYear);
        selectBoardYear.selectByIndex(yearPos);

        WebElement radioMen = webDriver.findElement(By.xpath(XPATH_RADIO_BUTTON));
        radioMen.click();

        WebElement nameTextBox = webDriver.findElement(By.xpath(XPATH_NAME_TEXT));
        nameTextBox.sendKeys("Jan");

        WebElement lastNameTextBox = webDriver.findElement(By.xpath(XPATH_LASTNAME_TEXT));
        lastNameTextBox.sendKeys("Kowalski");
    }
}
