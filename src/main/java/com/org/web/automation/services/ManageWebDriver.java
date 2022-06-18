package com.org.web.automation.services;

import org.openqa.selenium.WebDriver;

public class ManageWebDriver {
    private static WebDriver driver;

    public ManageWebDriver(WebDriver driver){
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
