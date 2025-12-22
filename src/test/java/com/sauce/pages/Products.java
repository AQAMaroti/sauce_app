package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products extends BasePage{

    private final By cart = By.className("shopping_cart_link");
    private final By checkout = By.id("checkout");
    private final By first = By.id("first-name");
    private final By last = By.id("last-name");
    private final By postal = By.id("postal-code");
    private final By cont = By.id("continue");
    private final By finish = By.id("finish");

    public Products(WebDriver driver) {
        super(driver);
    }

    public void addItemsToCart(String name){
        By product = By.xpath("//button[contains(@id, '"+name+"')]");
        click(product);
    }
    public void goToCart(){
        click(cart);
    }

    public void checkout(){
        click(checkout);
    }

    public void addDetails(String firstName, String lastName, String postalCode){
        type(first, firstName);
        type(last, lastName);
        type(postal, postalCode);
    }

    public void continu(){
        click(cont);
    }

    public void finish(){
        click(finish);
    }
}
