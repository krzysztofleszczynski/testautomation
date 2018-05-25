package com.jsystems.api.models;

import io.restassured.specification.RequestSpecification;

import java.io.Serializable;
import java.util.List;

public class UserDevice implements Serializable {

    public String imie;
    public String nazwisko;
    public List<Device> device;


}

