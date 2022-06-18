package com.org.web.automation.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ElementService {

    private WebDriver driver;
    public ElementService(WebDriver driver){
        this.driver = ManageWebDriver.getDriver();}

    public String getPageSource(){
        try{
            return driver.getPageSource();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void executeJavaScript(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("location.reload()");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getjsScript() throws IOException {
        String content = Files.readString(Paths.get("src/stack-file/jscript.txt"), StandardCharsets.US_ASCII);
        return content;
    }

    public boolean elementExists(String xpath)
    {
        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }
}
