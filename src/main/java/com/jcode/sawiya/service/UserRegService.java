package com.jcode.sawiya.service;

import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.mail.MessagingException;


/**
 * Created by Thakshila Bandara
 * Date: Dec 05, 2023
 * Time: 11.35.00 AM
 * Project: Sawiya | Volunteer
 */
public interface UserRegService {


    ResponseDTO userRegister(UserDTO userDTO) throws ParseException, MessagingException;
}
