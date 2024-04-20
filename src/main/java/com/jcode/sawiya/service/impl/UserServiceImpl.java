package com.jcode.sawiya.service.impl;

import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.model.User;
import com.jcode.sawiya.repository.RoleRepository;
import com.jcode.sawiya.repository.UserRepsitory;
import com.jcode.sawiya.service.EmailService;
import com.jcode.sawiya.service.RepresentativeService;
import com.jcode.sawiya.service.UserService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.CommonUtil;
import com.jcode.sawiya.util.LoggerUtil;
import com.jcode.sawiya.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.Objects;

import javax.mail.MessagingException;

/**
 * Created by Thakshila Bandara
 * Date: Dec 05, 2023
 * Time: 11.35.00 AM
 * Project: Sawiya | Volunteer
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepsitory userRepository;
    @Autowired
    private RepresentativeService representativeService;
    @Autowired
    private EmailService emailService;
    
    @Value("${spring.mail.username}")
    private String emailHost;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public ResponseDTO userRegister(UserDTO user) throws ParseException, MessagingException {

    	ResponseDTO<User> responseDTO;
    	User savedUser = userRepository.save(CommonUtil.getUserFromUserDTO(user));
    	
    	if (Objects.nonNull(savedUser)) {
        	emailService.sendEmail(emailHost, savedUser.getEmail(), CommonMessages.USER_REGITRATION_EMAIL_HEADER, CommonUtil.generateEmailBodyWithToken(savedUser.getFirstName(), savedUser.getEmailToken()));
        	logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_REGITRATION_EMAIL_SENT_SUCCESS));
        	
        	if (savedUser.getRoleId().getRoleId().equals(CommonMessages.ROLE_REPRESENTATIVE)) {
        		representativeService.registerRepresentative();
    		}
        	
        	responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_SUCCESS, CommonMessages.USER_REGISTERED_SUCCESSFULLY, savedUser);
            logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_REGISTERED_SUCCESSFULLY));
		}else{
			responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_FAILED, CommonMessages.USER_REGISTERED_FAILED);
            logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_REGISTERED_FAILED));
		}
    	return responseDTO;            
    }
}
