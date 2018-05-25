package com.jsystems.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;

public class DeviceModel {

    public String produce;
    @JsonProperty(value = "screen.size", required = true)
    @Size()
    public double screenSize;


}

