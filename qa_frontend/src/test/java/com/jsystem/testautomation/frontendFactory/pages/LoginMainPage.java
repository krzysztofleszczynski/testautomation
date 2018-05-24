package com.jsystem.testautomation.frontendFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMainPage extends BasePage{

    WebDriver driver;

    public LoginMainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
        @FindBy(id = "header")
        public WebElement headerPage;

        @FindBy(id = "search-component-1")

        public WebElement componentSearch;


    public void isContentPresent() {

    }
}

