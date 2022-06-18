package com.org.web.automation.services;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class WaitService {
    public WebDriverWait webDriverWait;
    private WebDriver driver;

    public WaitService(){
        this.driver = ManageWebDriver.getDriver();
    }

    public BaseElement waitForElementToBeClickable(BaseElement webElement) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return new BaseElement(webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void waitElementAndType(BaseElement element, String text) {
        waitElementToBeVisible(element);
        waitForElementToBeClickable(element);
        element.clearAndType(text);

    }

    private BaseElement waitElementToBeVisible(BaseElement webElement) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return new BaseElement(webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   /* private void waitElementToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement aboutMe;
        aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_me")));

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(29))
                .pollingEvery(Duration.ofSeconds(29))
                .ignoring(NoSuchElementException.class);
        driver.get("http://qaautomated.blogspot.in");
        WebElement aboutMe= fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("about_me"));
            }
        });
    }*/

   private WebDriverWait getWebDriverWait(){
       try{
           WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(20));
           return webDriverWait;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
   }

   public void waitForVisibilityToClick(String xpath){
       try{
           webDriverWait = getWebDriverWait();
           WebElement element;
           webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
       }catch (Exception e){
           e.printStackTrace();
       }
   }

}
