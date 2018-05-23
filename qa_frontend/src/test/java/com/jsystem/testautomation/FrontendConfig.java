package com.jsystem.testautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FrontendConfig {

    public WebDriver driver = null;

    @BeforeAll
    public static void setUpAll(){
    WebDriverManager.chromedriver().setup();

}

    @BeforeEach
    public void setUp(){
//pobranie drivera
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.addArguments("start-maximized");

    if (driver == null){
        driver = new ChromeDriver(chromeOptions);
    }
//    usuwamy cookies, ustawiamy pełne okno oraz ustawiamy timeout przy uruchamianiu okna
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
    @AfterEach
    public void tearDown(){
//    zamyka driver oraz przeglądarkę, ustawia się jako null żeby wyczyścić go.
    driver.quit();
    driver = null;

}

//public WebDriver setDown(){
//    WebDriverManager.chromedriver().notify();


}



