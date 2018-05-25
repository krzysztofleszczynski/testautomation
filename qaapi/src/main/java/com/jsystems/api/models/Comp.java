package com.jsystems.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comp {

    public String produce;
    @JsonProperty(value = "screen.size", required = true)
    public double screenSize;
}
