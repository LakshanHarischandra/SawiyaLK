package com.jcode.sawiya.service;

import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.model.User;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.mail.MessagingException;


public interface UserService {
    ResponseDTO userRegister(UserDTO user) throws ParseException, MessagingException;
}
