package com.jsystem.testautomation.frontendBDD.steps;

import com.jsystem.testautomation.Configuration;
import com.jsystem.testautomation.frontendBDD.page.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordpressSteps extends BaseSteps {
MainPage mainPage;
LoginPageEmail loginPageEmail;
LoginPasswordPage loginPasswordPage;
LoginMainPage loginMainPage;
PersonalPage personalPage;
NotificationPage notificationPage;
WebElement webElement;

    public WordpressSteps(StepsConfig config){
        super (config);
        try{
            driver = config.setUp();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(config.id);
        }
    }

    @Given("^User is on wordpress website \"([^\"]*)\"$")
        public void userIsOnWordpressWebsite(String website){
            driver.get(Configuration.WORDPRESS_BASE_URL);
//            MainPage = new mainPage(driver);
            mainPage = new MainPage(driver);
    }

    @When("^User click to login button$")
    public void userClickToLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        mainPage.loginButton.click();
    }

    @Then("^Email login page is displayed$")
    public void emailLoginPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        LoginPageEmail loginPageEmail = new LoginPageEmail(driver);
        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);

    }

    @When("^User enter email and click continue button$")
    public void userEnterEmailAndClickContinueButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        loginPageEmail= new LoginPageEmail(driver);
        loginPageEmail.continueButton.click();
    }

    @Then("^Passord login page is displayed$")
    public void passordLoginPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);
        loginPasswordPage.continueButton.sendKeys(Configuration.WORDPRESS_PASSWORD);

    }

    @When("^User enters password and press LogIn button$")
    public void userEntersPasswordAndPressLogInButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        loginPasswordPage = new LoginPasswordPage(driver);
        loginPasswordPage.loginButton.click();
    }

    @Then("^Main loged page is displayed$")
    public void mainLogedPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
     //   WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
      //  webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        Thread.sleep(3000);
//        loginMainPage = new LoginMainPage(driver);
   //     assertTrue(loginMainPage.avatar.isDisplayed());
       // loginMainPage = new LoginMainPage(driver);
        //loginMainPage.isContentPresent();
    }

    @When("^User press avatar$")
    public void userPressAvatar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        loginMainPage = new LoginMainPage(driver);
        loginMainPage.avatar.click();
    }

    @Then("^Personal page is displayed$")
    public void personalPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        personalPage = new PersonalPage(driver);
        personalPage.notification.click();
    }

    @When("^User clicks notyfication link$")
    public void userClicksNotyficationLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        notificationPage = new NotificationPage(driver);
        assertTrue(personalPage.titleNotification.isDisplayed());
        personalPage.notification.click();
    }

    @Then("^Notyfication page is displayed$")
    public void notyficationPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        notificationPage = new NotificationPage(driver);
        notificationPage.isContentPresent();
        notificationPage.checkbox.isDisplayed();
        notificationPage.checkbox.isSelected();
    }

    @When("^User press checkbox$")
    public void userPressCheckbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        notificationPage.checkbox.click();
    }

    @Then("^Checkbox is unselected$")
    public void checkboxIsUnselected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        assertFalse(notificationPage.checkbox.isSelected());
        notificationPage.checkbox.click();
    }
}

