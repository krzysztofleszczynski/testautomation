package com.jsystem.testautomation.frontendFactory.tests;

import com.jsystem.testautomation.Configuration;
import com.jsystem.testautomation.frontendFactory.FrontendConfig;
import com.jsystem.testautomation.frontendFactory.pages.LoginMainPage;
import com.jsystem.testautomation.frontendFactory.pages.LoginPageEmail;
import com.jsystem.testautomation.frontendFactory.pages.LoginPasswordPage;
import com.jsystem.testautomation.frontendFactory.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrontendTestMainPage extends FrontendConfig {

    MainPage  mainPage;
    LoginPageEmail loginPageEmail;
    LoginPasswordPage loginPasswordPage;
    LoginMainPage loginMainPage;

@Test
@DisplayName("Test of main page content - 1 ")
    public void contentMainPageTest(){
//wchodzimy na podaną strone
    driver.get("https://wordpress.com");
    MainPage mainPage = new MainPage(driver);
    mainPage.isContentPresent();

}

@Test
@DisplayName("Login Test 2 ")
public void LoginPageTest(){

 // można podać na sztywno w teście  driver.get("https://wordpress.com");
 // albo podając ze zmiennej zapisanej w pliku

    driver.get(Configuration.WORDPRESS_BASE_URL);
    MainPage mainPage = new MainPage(driver);
    mainPage.loginButton.click();
    LoginPageEmail loginPageEmail = new LoginPageEmail(driver);
    loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
    loginPageEmail.continueButton.click();
    //loginPageEmail.waitForVisiblityOfElement(loginPageEmail.continueButton, 10);

    LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);
    loginPasswordPage.continueButton.sendKeys(Configuration.WORDPRESS_PASSWORD);
    loginPasswordPage.loginButton.click();
   // loginPasswordPage.waitForVisiblityOfElement(loginPasswordPage.continueButton, 10);

    //MainLogedPage mainLogedPage = new MainLogedPage(driver);
    //mainLogedPage.isContentPresent();

    LoginMainPage loginMainPage = new LoginMainPage(driver);
    loginMainPage.isContentPresent();
//    loginMainPage.headerPage.findElement(WebElement);
 //   loginMainPage.componentSearch.findElement(driver);
 //   LoginMainPage.headerPage.findElement(headerPage)

}


}
