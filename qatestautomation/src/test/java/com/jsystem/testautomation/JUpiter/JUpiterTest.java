package com.jsystem.testautomation.JUpiter;

import com.jsystem.testautomation.JUpiter.ConfigJUpiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

@DisplayName("JUpiter Test Class")
public class JUpiterTest extends ConfigJUpiter {
    String testowyString = "SecondTest";

    @Nested
    @DisplayName("Test nested classa")
    public class JUpiterNestedClass {

    @Test
    @DisplayName("Test 1  for check condition of test string")
public void secendNestedTest(){
    assertTrue(true == true);

    assertTrue(testowyString.equals("SecondTest"));
    assertTrue("message from assertTrue", 5 == 2 + 3);
    assertFalse("message from asserrTrue", 5 == 3 + 3);
    assertFalse("message from assertTrue", testowyString.equals("Adam"));
    assertThat(testowyString, is("SecondTest"));
    assertEquals(testowyString, "SecondTest");
    assertSame(testowyString, "SecondTest");
    assertThat(testowyString, containsString("Second"));
    assertThat(testowyString, equalTo("SecondTest"));
    assertThat(testowyString, endsWith("Test"));


    }
    }

    @Test
    @DisplayName("Test 2 for check condition of test string")
    public void secendTest(){
        assertTrue(true == true);

        assertTrue(testowyString.equals("SecondTest"));
        assertTrue("message from assertTrue", 5 == 2 + 3);
        assertFalse("message from asserrTrue", 5 == 3 + 3);
        assertFalse("message from assertTrue", testowyString.equals("Adam"));
        assertThat(testowyString, is("SecondTest"));
        assertEquals(testowyString, "SecondTest");
        assertSame(testowyString, "SecondTest");
        assertThat(testowyString, containsString("Second"));
        assertThat(testowyString, equalTo("SecondTest"));
        assertThat(testowyString, endsWith("Test"));


    }

}
