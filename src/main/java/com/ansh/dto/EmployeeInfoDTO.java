package com.ansh.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeInfoDTO {

    private String id;

    private String name;

    private String department;

    private String address;

    private String city;

    private String state;

    @JsonProperty("zip_code")
    private int zipCode;
}
