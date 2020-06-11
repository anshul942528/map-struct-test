package com.ansh.dto.response;

import lombok.Data;

@Data
public class ResponseDTO<T> {

    private String status;

    private String message;

    private T result;
}
