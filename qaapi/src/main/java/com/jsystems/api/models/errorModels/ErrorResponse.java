package com.jsystems.api.models.errorModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorResponse {

    @JsonProperty(value = "Error")
    public ErrorObject error;


    public class ErrorObject {
        @JsonProperty(value = "error.code")
        public int errorcode;

        @JsonProperty(value = "validation_erro")
        public String validationErro;
        public String message;

    }
}
