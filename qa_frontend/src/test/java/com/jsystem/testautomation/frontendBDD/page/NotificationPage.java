package com.jsystem.testautomation.frontendBDD.page;

import com.jsystem.testautomation.frontendFactory.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationPage extends BasePage{

    WebDriver driver;

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"primary\"]/main/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/input"));

    public boolean isContentPresent(){
        assertTrue(checkbox.isDisplayed());
        assertTrue(checkbox.isSelected());
        return true;
    }
}

