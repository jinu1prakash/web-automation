package com.org.web.automation.mock;

import com.org.web.automation.services.BaseElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MockWebElement {
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement textBox;

    public BaseElement setXpath(){
        return new BaseElement(textBox);
    }
}
