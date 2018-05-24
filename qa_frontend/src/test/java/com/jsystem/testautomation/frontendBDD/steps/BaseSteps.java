package com.jsystem.testautomation.frontendBDD.steps;

import org.openqa.selenium.WebDriver;

public class BaseSteps {
    WebDriver driver;
// to jest typowy konstruktor - dziedziczymy BaseStepa i go wywołujemy
// nie musimy tego umieszcać, ale to pomaga - optymalizuje kod

    public BaseSteps(StepsConfig config){

        this.driver = config.setUp();

    }
}
