package com.ansh.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String address_line;

    private String city_name;

    private String dist_name;

    private String state_name;

    private int pin_code;
}
