package com.jsystem.testautomation.Junit;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.*;

public class JUnitTest extends ConfigJunit {


    @Before
    public void SetUp() {
    System.out.println("=========== @Before ==========");
    }


    @After
    public void tearDown() {
        System.out.println("=========== @After ==========");

    }


    String testowyString = "FirstTest";

    @Test
    public void FirstTest() {

        assertTrue(true == true);

        assertTrue(testowyString.equals("FirstTest"));
        assertTrue("message from assertTrue", 5 == 2 + 3);
        assertFalse("message from asserrTrue", 5 == 3 + 3);
        assertFalse("message from assertTrue", testowyString.equals("Adam"));
        assertThat(testowyString, is("FirstTest"));
        assertEquals(testowyString, "FirstTest");
        assertSame(testowyString, "FirstTest");
        assertThat(testowyString, containsString("First"));
        assertThat(testowyString, equalTo("FirstTest"));
        assertThat(testowyString, endsWith("Test"));

        System.out.println(0.2 * 0.2);

        assertFalse(0.2 * 0.2 == 0.04);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
    }


@Test
public void arraysTest() {
    List<Integer> list1 = Arrays.asList(1,2,3,4,5);
    List<Integer> list1a = Arrays.asList(1,2,3,4,5);
    List<String> list2 = Arrays.asList("Ewa", "Adam", "Ania", "Robert", "Iwona");
    List<String> list2a = Arrays.asList("Ewa","Adam","Ania");
    List<String> list3 = new ArrayList<>();

    assertArrayEquals(list1.toArray(),list1a.toArray());
    assertThat(list2, hasSize(5));

    assertThat(list1, containsInAnyOrder(1,2,3,5,4));
    assertThat(list2, not (IsEmptyCollection.empty()));

    assertThat(list2, not(hasSize(6)));
    assertThat(list1, hasItem(1));
    assertThat(list2, hasItem("Ewa"));
    assertThat(list2, not(hasItem("Ewa2")));

    assertTrue(list2.containsAll(list2a));
    assertThat(list1.size(), is(5));
    assertThat(list1.size(), not (is(6)));
    assertFalse(list2a.containsAll(list2));

    }

    @Test
    public void jcabiTest(){

     assertThat(testowyString, matchesPattern(".*Test"));
     assertThat(testowyString, matchesPattern("^First.*"));
     assertThat(testowyString, matchesPattern(".*irst.*t$") );
     assertThat("12345678", matchesPattern("[0-9]+"));

    }

}
