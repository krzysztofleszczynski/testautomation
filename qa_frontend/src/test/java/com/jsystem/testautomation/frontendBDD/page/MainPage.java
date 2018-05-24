package com.jsystem.testautomation.frontendBDD.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BasePage {
    WebDriver driver;

    public MainPage(WebDriver driver)  {
     super(driver);
//     this.driver = driver;
        PageFactory.initElements(driver, this);
//   skrót klawiszowy: alt+insetr - podpowiada że możemy generować stringi, konstruktory itp.
    }

    @FindBy(id = "navbar-login-link")
    public WebElement loginButton;

    @FindBy(id = "hero-cta")
    public WebElement getStartedButton;

    @FindBy(css = "a#hero-plans-anchor.button.is-more-link.is-large")
    public WebElement seePlansButton;

    @FindBy(css = "div.hp-hero__wrapper h1 span.no-widows")
    public WebElement textWindow;

    public boolean isContentPresent() {

    //    public WebElement loginButton = driver.findElement(By.id("navbar-login-link"));

        assertTrue(textWindow.isDisplayed());
      //  assertTrue(textWindow.getText().equals(TestDataHelper.workpressMainText));
        assertTrue(loginButton.isDisplayed());
        assertTrue(getStartedButton.isDisplayed());
        assertTrue(seePlansButton.isDisplayed());

        return true;



//      isDisplayed() - sprawdza czy jest w DUM (), czy się wyświetla w HTMLu
//      isEnabled - sprawdź czy jest włączony
//      isSelected - sprawdź czy to jest zaznaczone

//        try{
//            Thread.sleep(4000);
//        } catch (InterruptedException e){
//            e.printStackTrace();

    }

    }

