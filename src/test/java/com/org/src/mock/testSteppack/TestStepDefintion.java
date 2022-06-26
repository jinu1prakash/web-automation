package com.org.src.mock.testSteppack;

import com.org.web.automation.services.ElementService;
import com.org.web.automation.services.ManageWebDriver;
import com.org.web.automation.services.WaitService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class TestStepDefintion {
    private WebDriver driver = ManageWebDriver.getDriver();
    private WaitService waitService = new WaitService();

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement textBox;
    @FindBy(xpath = "//div[contains(text(),'I agree')]")
    public WebElement iAgree;

    @Given("^Navigate to Google Home$")
    public void navigate_to_google_home() throws Throwable {
        Executioner.elementService.openBrowser("https://www.google.com/");
        //driver.navigate().to("https://www.google.com/");
    }

    @And("^I enter the text HelloWorld$")
    public void i_enter_the_text_helloworld() throws Throwable {
        if(WaitService.PAGESOURCE.contains("Reject")){
            waitService.waitForVisibilityToClick("//button//div[contains(text(),'Reject')]");
            System.out.println("Clicked 1st Xpath");
        }else{
            waitService.waitForVisibilityToClick("(//button[contains(text(),'')])[4]");
            System.out.println("Clicked 2nd Xpath");
        }
        //waitService.waitForVisibilityToClick("//button//div[contains(text(),'Reject')]");//(//button[contains(text(),'')])[4]
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Hello World");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
    }

    @Then("^I navigate to search result$")
    public void i_navigate_to_search_result() throws Throwable {
        driver.getPageSource().contains("Hello");
    }

}
