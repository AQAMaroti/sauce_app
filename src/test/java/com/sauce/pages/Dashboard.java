package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    private final By title = By.className("app_logo");

    public boolean isDisplayed(String logo) {
        return driver.findElement(title).getText().equals(logo);
    }
}
