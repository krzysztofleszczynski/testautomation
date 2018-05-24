package com.jsystem.testautomation.frontendBDD.page;

import com.jsystem.testautomation.frontendFactory.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelperPage extends BasePage{

    WebDriver driver;

    public HelperPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    }


