package com.sauce.driver;

import com.sauce.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory() {
        //
    }

    public static void initDriver(Browsers browsers, String headless) {
        WebDriver driver;
        boolean hl = Boolean.getBoolean(headless);

        switch (browsers) {
            case CHROME -> {
                ChromeOptions cp = getChromeOptions(hl);
                driver = new ChromeDriver(cp);
            }
            case FIREFOX -> {
                FirefoxOptions fx = new FirefoxOptions();
                if (hl) {
                    fx.addArguments("--headless");
                }
                driver = new FirefoxDriver(fx);
            }

            case EDGE -> {
                EdgeOptions ed = new EdgeOptions();
                if (hl) ed.addArguments("--headless");
                driver = new EdgeDriver(ed);
            }

            default -> throw new IllegalArgumentException("Driver not supported");
        }
        DriverManager.setWebdriver(driver);

    }

    private static ChromeOptions getChromeOptions(boolean hl) {
        ChromeOptions cp = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        prefs.put("profile.password_manager_leak_detection", false);

        cp.setExperimentalOption("prefs", prefs);

        cp.addArguments("--disable-notifications");
        if (hl) {
            cp.addArguments("--headless");
        }
        cp.addArguments("--maximized");
        return cp;
    }

    public static void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
