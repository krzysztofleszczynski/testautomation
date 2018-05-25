package com.jsystems.api;

import com.jsystems.api.serviceDao.ServiceDao;
import com.jsystems.api.serviceDao.TestUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class JBDCTest {

    @Test
    @DisplayName("Test getOne")
    public void jdbcTest(){
        ServiceDao userServiceDao = new ServiceDao();
        TestUser testUser = userServiceDao.getOne(1l);
        System.out.println(testUser.toString());

        assertTrue(testUser.getId()==1);
        assertTrue(testUser.getName().equals("Piotr"));
        assertTrue(testUser.getSurname().equals("Kowalski"));

    }

    @Test
    @DisplayName("Test getAll")
    public void jdbcTestAll(){
        ServiceDao userServiceDao = new ServiceDao();

       // TestUser testUser = userServiceDao.getAll();
//        System.out.println(testUser.toString());

//        assertTrue(testUser.getId()==1);
//        assertTrue(testUser.getName().equals("Piotr"));
//        assertTrue(testUser.getSurname().equals("Kowalski"));

    }

}
