package com.sauce.stepDefinitions;

import com.sauce.driver.DriverManager;
import com.sauce.pages.Dashboard;
import com.sauce.pages.Login;
import com.sauce.pages.Products;
import com.sauce.util.AllureAttachments;
import com.sauce.util.ExcelManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class LoginSteps {
    private final Login login;
    private final Dashboard dashboard;
    private final WebDriver driver;
    private Map<String, String> data;

    public LoginSteps() {
        driver = DriverManager.getDriver();
        this.login = new Login(driver);
        this.dashboard = new Dashboard(driver);
    }

    @When("the user logs in with username and password")
    public void theUserLogin() {
        login.login(data.get("USERNAME"), data.get("PASSWORD"));
        AllureAttachments.attachments(driver, "login");
    }

    @Then("the dashboard title should be {string}")
    public void verifyTitle(String title) {
        Assert.assertTrue(dashboard.isDisplayed(title), "title matched");
        AllureAttachments.attachments(driver, "Title");
    }

    @Then("user add to cart")
    public void addProductToCart() throws InterruptedException {
        Products products = new Products(driver);
            products.addItemsToCart(data.get("PROD_NAME"));
            Thread.sleep(3000);
    }

    @Given("user read data from excel sheet {string} sheet {string} for test {string}")
    public void userReadDataFromExcelSheetSheetForTest(String fileName, String sheetName, String tc_no) throws FileNotFoundException {
        data = ExcelManager.getData(fileName, sheetName, tc_no);
    }
}
