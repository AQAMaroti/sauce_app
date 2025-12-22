package com.sauce.stepDefinitions;

import com.sauce.driver.DriverManager;
import com.sauce.pages.Products;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.*;

import java.util.Map;

public class ProductStep {
    private Products products;
    private WebDriver driver;

    public ProductStep() {
        this.driver = DriverManager.getDriver();
        this.products = new Products(driver);
    }

    @Then("user add to cart")
    public void addProductToCart(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String product = row.get("product");

            if (product == null || product.trim().isEmpty()) {
                throw new IllegalArgumentException("Missing 'product' value in DataTable row: " + row);
            }

            products.addItemsToCart(product);
            Thread.sleep(3000);
        }

    }
    @Then("the user navigates to the cart")
    public void the_user_navigates_to_the_cart() {
       products.goToCart();
    }
    @Then("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
       products.checkout();
    }
    @Then("the user enters checkout details with {string} {string} {string}")
    public void the_user_enters_checkout_details_with(String first, String last, String postal) {
       products.addDetails(first,last,postal);
    }
    @Then("the user continues to the overview page")
    public void the_user_continues_to_the_overview_page() {
       products.continu();
    }
    @Then("the user completes the checkout")
    public void the_user_completes_the_checkout() {
       products.finish();
    }
    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
       String success=driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(success, "Thank you for your order!", "message");
    }


}
