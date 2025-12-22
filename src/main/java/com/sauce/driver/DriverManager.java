package com.sauce.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> WEBDRIVER = new ThreadLocal<>();

    private DriverManager(){

    }

    static void setWebdriver(WebDriver driver){
        WEBDRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return WEBDRIVER.get();
    }

    static void unload(){
        WEBDRIVER.remove();
    }

}
