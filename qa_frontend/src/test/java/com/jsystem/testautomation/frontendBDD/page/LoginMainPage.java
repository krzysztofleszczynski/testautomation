package com.jsystem.testautomation.frontendBDD.page;

import com.jsystem.testautomation.frontendFactory.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginMainPage extends BasePage{

    WebDriver driver;

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement avatar = driver.findElement(By.cssSelector("a[data-tip-target=\"me\"]"));
    public WebElement mySite = driver.findElement(By.cssSelector("a[data-tip-target=\"my-sites\"] span"));

    public boolean isContentPresent(){
        assertTrue(avatar.isDisplayed());
        assertTrue(mySite.isDisplayed());
        return true;
    }
}

