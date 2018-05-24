package com.jsystem.testautomation.frontendBDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    //klasa uruchamiająca testy
    //klasa cucumbera którą on sam ją steruje
    //features - trzymamy scenariusze, mówi gdzie ma szukać plików z rozszerzeniem BDD
    //glue - tu będą trzymane kroki testu, mówimy mu gdzie ma szukać stepów
    //plugin - tu będą trzymane i generowane raporty, testy sfailowane wrzuc do rerun
    //tags - otagujemy testy, wskażemy co ma wykonać za pomocą tagów
    // tags - tylko z jednym takiem możemy wywołać, grugi musimy wyłączyć tyldą - ~

    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "classpath:com.jsystem.testautomation",
            plugin = {"html:target/cucumber-html-report", "rerun:target/return.txt"},
            tags = {"@wordpress"
                    //, ~"@login"  mvn clean install -Dcucumber.option="tags @worpress"
// uruchamiamy z poziomu konsoli w mavenie podając z jakim tagiem
            }
    )

    public class RunTest {

//    public void RunTRest(){    }


}

