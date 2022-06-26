package com.org.src.mock.testSteppack;

import com.org.web.automation.services.ElementService;
import com.org.web.automation.services.ManageWebDriver;
import com.org.web.automation.services.WaitService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraHoverStepDefinition {
    private WebDriver driver = ManageWebDriver.getDriver();
    private WaitService waitService = new WaitService();

  private Executioner executioner = new Executioner();
    @Given("^I open the (.+)$")
    public void i_open_the(String webpage) throws Throwable {
      Executioner.elementService.openBrowser(webpage);

    }

    @When("^I hover and click the Casual Shirt link in Mens$")
    public void i_hover_and_click_the_casual_shirt_link_in_mens() throws Throwable {
        /*executioner.waitService.waitForVisibilityToClick("(//div[@class='product-imageSliderContainer']/child::div)[1]");*/
        waitService.waitForVisibilityToClick("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[1]/div/a");
//        Executioner.waitService.waitForVisibilityToClick("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[1]/div/a");
    }

}
