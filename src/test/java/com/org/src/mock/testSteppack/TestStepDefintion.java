package com.org.src.mock.testSteppack;

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
    private WebDriver driver;
    private WaitService waitService;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement textBox;
    @FindBy(xpath = "//div[contains(text(),'I agree')]")
    public WebElement iAgree;

    @Before
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ManageWebDriver driverManager = new ManageWebDriver(driver);
            waitService = new WaitService();
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
        waitService.waitForVisibilityToClick("(//button[contains(text(),'')])[5]");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Hello World");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
    }

    @Then("^I navigate to search result$")
    public void i_navigate_to_search_result() throws Throwable {
        driver.getPageSource().contains("Hello");
    }

}
