package com.jcode.sawiya.service.impl;

import com.jcode.sawiya.controller.AuthorizationController;
import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.model.User;
import com.jcode.sawiya.repository.RoleRepository;
import com.jcode.sawiya.repository.UserRepsitory;
import com.jcode.sawiya.service.EmailService;
import com.jcode.sawiya.service.RepresentativeService;
import com.jcode.sawiya.service.UserRegService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.CommonUtil;
import com.jcode.sawiya.util.LoggerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
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
public class UserRegServiceImpl implements UserRegService {

    @Autowired
    private UserRepsitory userRepository;
    @Autowired
    private RepresentativeService representativeService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmailService emailService;
    
    @Value("${spring.mail.username}")
    private String emailHost;

    private final Logger logger = LoggerFactory.getLogger(UserRegServiceImpl.class);


    @Override
    public ResponseDTO userRegister(UserDTO userDTO) throws ParseException, MessagingException {


            if(Objects.nonNull(userDTO)){

                User savedUser = userRepository.save(CommonUtil.getUserFromUserDTO(userDTO));
                if (Objects.nonNull(savedUser)) {
                	emailService.sendEmail(emailHost, savedUser.getEmail(), CommonMessages.USER_REGITRATION_EMAIL_HEADER, CommonUtil.generateEmailBodyWithToken(savedUser.getFirstName(), savedUser.getEmailToken()));
                	logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_REGITRATION_EMAIL_SENT_SUCCESS));
				}

                if(roleRepository.findRoleByRoleId(userDTO.getRoleId()).equals(CommonMessages.ROLE_REPRESENTATIVE)){

                    representativeService.representativeRegister();
                }
                return ResponseDTO.builder().
                        message(CommonMessages.USER_SAVED_SUCCESSFULLY).
                        successOrFail(CommonMessages.RESPONSE_DTO_SUCCESS).
                        build();
            }else{
                return ResponseDTO.builder().
                        message(CommonMessages.EXCEPTION_OCCURED).
                        successOrFail(CommonMessages.RESPONSE_DTO_FAILED).
                        build();

            }
    }
}
