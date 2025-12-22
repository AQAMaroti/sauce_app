package com.sauce.stepDefinitions;

import com.sauce.driver.DriverManager;
import com.sauce.pages.Dashboard;
import com.sauce.pages.Login;
import com.sauce.util.AllureAttachments;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private final Login login;
    private final Dashboard dashboard;
    private final WebDriver driver;
    public LoginSteps() {
        driver = DriverManager.getDriver();
        this.login = new Login(driver);
        this.dashboard = new Dashboard(driver);
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogin(String username, String password) {
        login.login(username, password);
        AllureAttachments.attachments(driver, "login");
    }

    @Then("the dashboard title should be {string}")
    public void verifyTitle(String title) {
        Assert.assertTrue(dashboard.isDisplayed(title), "title matched");
        AllureAttachments.attachments(driver, "Title");
    }
}
