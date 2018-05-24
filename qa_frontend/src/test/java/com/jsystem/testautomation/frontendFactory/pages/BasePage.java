package com.jsystem.testautomation.frontendFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebElement element;
    public BasePage(WebDriver driver){ this.driver = driver;    }

    public void waitForElementToBeClickable(WebElement webElement, int maxWaitTime) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, maxWaitTime);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

        public void waitForVisiblityOfElement( WebElement element, int maxWaitTime) {
            WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
            wait.until(ExpectedConditions.visibilityOf(element));


    }
}
