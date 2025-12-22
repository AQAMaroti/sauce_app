package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {

    private final By user = By.id("user-name");
    private final By pass = By.id("password");
    private final By submit = By.id("login-button");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(user, username);
        type(pass, password);
        click(submit);
    }

}
