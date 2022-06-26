package com.org.src.mock.testSteppack;

import com.org.web.automation.services.ElementService;
import com.org.web.automation.services.ManageWebDriver;
import com.org.web.automation.services.WaitService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Executioner {
    public WebDriver driver;
    public static WaitService waitService;
    public static ElementService elementService;
    @Before
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ManageWebDriver driverManager = new ManageWebDriver(driver);
            waitService = new WaitService();
            elementService = new ElementService(driver);
            WaitService.PAGESOURCE = driver.getPageSource();
            driver.manage().window().maximize();
        }
    }
   /* @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }*/
}
