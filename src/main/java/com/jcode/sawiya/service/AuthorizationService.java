package com.jcode.sawiya.service;

import java.text.ParseException;
import java.util.Map;
import com.jcode.sawiya.dto.AuthorizeDTO;
import com.jcode.sawiya.dto.ResponseDTO;

/**
 * Created by Lakshan Harischandra
 * Date: Sep 18, 2021
 * Time: 8:08:40 PM
 * Project: Sawiya | Volunteer
*/
public interface AuthorizationService {
	ResponseDTO<AuthorizeDTO> authorizeUser(String email, String password);
	ResponseDTO<AuthorizeDTO> authorizeUserWithEmailToken(String email, String password, String emailToken) throws ParseException;
	Map<Integer, String> getUserPrivileges(int roleId);
}


