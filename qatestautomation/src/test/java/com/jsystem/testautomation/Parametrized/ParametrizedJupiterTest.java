package com.jsystem.testautomation.Parametrized;

import com.jsystem.testautomation.GamePlay;
import com.jsystem.testautomation.JUpiter.ConfigJUpiter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("All")
@DisplayName("Parametrized test with JUnit 5")
public class ParametrizedJupiterTest extends ConfigJUpiter {


 @ParameterizedTest
 @CsvSource({"Hello , 5", "Hello JUnit 5, 15", "'Hello, JUnit, 5!', 25"})
 public void ParametrizedTest(String param1, int param2){
    assertTrue(param1.contains("Hello"));
    assertTrue(param2 % 5 ==0);

    }
    @Tag("All")
    @DisplayName("Check if it contains Hello fot String params")
    @ParameterizedTest()
    @CsvSource({"Hello", "FirstHello", "Hello Word"})
    public void ParametrizedFirstTestOneParams(String param1){
     assertTrue(param1.contains("Hello"));
    }

    @Tag("All")
    @DisplayName("Check if it contains  for int params")
    @ParameterizedTest()
    @CsvSource({"5", "15", "25"})
    public void ParametrizedSecondTestTwoParams(int param2){
        assertTrue(param2 % 5 == 0);
    }

    @Tag("All")
    @DisplayName("Check if file for params")
    @ParameterizedTest()
    @CsvFileSource(resources = "/plik.csv")
    public void ParametrizedTestCsvFileParams(String word, int age){
        assertTrue(word.contains("Hello"));
        assertTrue(age % 5 == 0);

    }
    @Tag("All")
    @DisplayName("Check if file where age is String")
    @ParameterizedTest()
    @CsvFileSource(resources = "/plik.csv")
    public void ParametrizedTestCsvFileParamsInt(String word, Integer age){
        assertTrue(word.contains("Hello"));
        assertTrue(age % 5 == 0);
        assertTrue(age instanceof Integer);

    }
    @Tag("All")
    @DisplayName("Check if file where age is String word")
    @ParameterizedTest()
    @CsvFileSource(resources = "/plik.csv")
    public void ParametrizedTestCsvFileParamsString(String word){
        assertTrue(word.contains("Hello"));
        assertTrue(word instanceof String);

    }
    GamePlay gamePlay = new GamePlay();

@Tag("Repeated")
@Tag("All")
   @Test
   @DisplayName("Test for checking if exception was throw")
@RepeatedTest(3)

public void exceptionTest() {
     assertThrows(IllegalArgumentException.class,
             () -> {
            gamePlay.play(0);
             }

             );
   }


}
