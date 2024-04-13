package com.jcode.sawiya.util;

import com.jcode.sawiya.dto.ResponseDTO;


/**
 * Created by Lakshan Harischandra
 * Date: Apr 8, 2022
 * Time: 10:13:11 PM
 * Project: Sawiya | Volunteer
*/
public class ResponseUtil {

	/*
    Response attributes declare here
    */
    public static final String RESPONSE_DATA = "response";
    public static final String ERROR_RESPONSE = "errorResponse";


    public static ResponseDTO getResponseDto(String isSuccessOrFail, String message, Object data) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessOrFail(isSuccessOrFail);
        responseDTO.setMessage(message);
        responseDTO.setData(data);
        return responseDTO;
    }

    public static ResponseDTO getResponseDto(String isSuccessOrFail, String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessOrFail(isSuccessOrFail);
        responseDTO.setMessage(message);
        return responseDTO;
    }
    
}


