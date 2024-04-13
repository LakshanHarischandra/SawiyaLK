package com.jcode.sawiya.controller;

import java.text.ParseException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jcode.sawiya.dto.AuthorizeDTO;
import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.model.User;
import com.jcode.sawiya.service.AuthorizationService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.LoggerUtil;
import com.jcode.sawiya.util.RequestEndPoints;

/**
 * Created by Lakshan Harischandra
 * Date: Sep 18, 2021
 * Time: 7:55:36 PM
 * Project: Sawiya | Volunteer
*/
@RestController
@CrossOrigin(RequestEndPoints.REACT_CROSS_ORIGIN)
public class AuthorizationController {
	
	private final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

    @Autowired
    private AuthorizationService authorizationService;
	
    @ResponseBody 
	@PostMapping(path = RequestEndPoints.SIGN_IN_USER)
	public ResponseDTO<AuthorizeDTO> signIn(@RequestBody User user) {
		ResponseDTO<AuthorizeDTO> responseDTO = new ResponseDTO<>();
		if (Objects.nonNull(user.getEmail()) && Objects.nonNull(user.getPassword())) {
            responseDTO = authorizationService.authorizeUser(user.getEmail(), user.getPassword());
            if (Objects.nonNull(responseDTO.getData()) && responseDTO.getSuccessOrFail().equalsIgnoreCase(CommonMessages.RESPONSE_DTO_SUCCESS)) {	      	                
                logger.info(LoggerUtil.setLoggerInfo(responseDTO.getData().getUserDto().getFirstName(), this.getClass().toString(), responseDTO.getMessage()));
            } else {
                logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), responseDTO.getMessage()));
            }
        }
	    return responseDTO;
	 }
    
    @ResponseBody 
	@PostMapping(path = RequestEndPoints.REGISTER_USER_WITH_EMAIL_TOKEN)
	public ResponseDTO<AuthorizeDTO> signInWithEmailToken(@RequestBody User user) {
		ResponseDTO<AuthorizeDTO> responseDTO = new ResponseDTO<>();
		if (Objects.nonNull(user.getEmail()) && Objects.nonNull(user.getPassword()) && Objects.nonNull(user.getEmailToken())) {
            try {
				responseDTO = authorizationService.authorizeUserWithEmailToken(user.getEmail(), user.getPassword(), user.getEmailToken());
				if (Objects.nonNull(responseDTO.getData()) && responseDTO.getSuccessOrFail().equalsIgnoreCase(CommonMessages.RESPONSE_DTO_SUCCESS)) {	      	                
	                logger.info(LoggerUtil.setLoggerInfo(responseDTO.getData().getUserDto().getFirstName(), this.getClass().toString(), responseDTO.getMessage()));
	            } else {
	                logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), responseDTO.getMessage()));
	            }
			} catch (ParseException e) {
				e.printStackTrace();
			}            
        }
	    return responseDTO;
	 }
}


