package com.jsystem.testautomation.JUpiter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class ConfigJUpiter {

    @AfterEach
    public void AfterEach() {
        System.out.println("=========== @AfterClass ==========");
    }

    @BeforeAll
    public static void BeforeAll() {

        System.out.println("=========== @BeforeClass ==========");
    }


}
