package com.jsystem.testautomation.frontendBDD.page;

import com.jsystem.testautomation.frontendFactory.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalPage extends BasePage{

    WebDriver driver;

    public PersonalPage(WebDriver driver) {
        super(driver);
    }
    public WebElement titleNotification = driver.findElement(By.className("profile-gravatar__user-display-name"));

    public WebElement notification = driver.findElement(By.cssSelector("a[href=\"/me/notifications\"]"));

    public boolean isContentPresent(){
        assertTrue(titleNotification.isDisplayed());
        assertTrue(notification.isDisplayed());
        return true;
    }
    }


