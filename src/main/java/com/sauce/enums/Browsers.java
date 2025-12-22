package com.sauce.enums;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String browserName;

    Browsers(String name){
        this.browserName = name;
    }

    public String getBrowserName(){
        return browserName;
    }

    public static Browsers fromString(String browser){
        return Browsers.valueOf(browser.toUpperCase());
    }
}
