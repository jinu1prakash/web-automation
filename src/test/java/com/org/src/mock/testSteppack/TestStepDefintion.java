package com.org.src.mock.testSteppack;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class TestStepDefintion {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/main/resources/webdrivers/chrome/chromedriver.exe").toString());
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("^Navigate to Google Home$")
    public void navigate_to_google_home() throws Throwable {
        driver.navigate().to("https://www.google.com/");
    }

    @And("^I enter the text HelloWorld$")
    public void i_enter_the_text_helloworld() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Hello World");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
    }

    @Then("^I navigate to search result$")
    public void i_navigate_to_search_result() throws Throwable {
        driver.getPageSource().contains("Hello");
    }

}
