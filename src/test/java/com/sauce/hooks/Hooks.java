package com.sauce.hooks;

import com.sauce.config.ConfigLoader;
import com.sauce.driver.DriverFactory;
import com.sauce.driver.DriverManager;
import com.sauce.enums.Browsers;
import com.sauce.util.AllureAttachments;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks {
private WebDriver driver;

    @Before
    public void setup() {
        DriverFactory.initDriver(Browsers.CHROME, "true");
        driver = DriverManager.getDriver();
        driver.get(ConfigLoader.getProperty("url"));

    }


    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            AllureAttachments.attachments(DriverManager.getDriver(), "Failed screenshot");
            AllureAttachments.addText("Scenario", scenario.getName());
        }
        DriverFactory.quit();
    }
}
