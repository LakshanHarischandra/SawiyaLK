package com.jcode.sawiya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.io.Serializable;

/**
 * Created by Lakshan Harischandra
 * Date: Apr 8, 2022
 * Time: 9:01:08 PM
 * Project: Sawiya | Volunteer
*/

@Builder
@AllArgsConstructor
public class ResponseDTO<T> implements Serializable {

    private String message;
    private String successOrFail;
    private T data;
    private String jwtToken;

    public ResponseDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccessOrFail() {
        return successOrFail;
    }

    public void setSuccessOrFail(String successOrFail) {
        this.successOrFail = successOrFail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}


