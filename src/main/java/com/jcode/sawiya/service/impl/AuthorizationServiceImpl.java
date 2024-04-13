package com.jcode.sawiya.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcode.sawiya.dto.AuthorizeDTO;
import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.model.Privilege;
import com.jcode.sawiya.model.User;
import com.jcode.sawiya.repository.PrivilegeRepository;
import com.jcode.sawiya.repository.UserRepsitory;
import com.jcode.sawiya.service.AuthorizationService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.CommonUtil;
import com.jcode.sawiya.util.LoggerUtil;
import com.jcode.sawiya.util.ResponseUtil;
import com.jcode.sawiya.util.SecurityUtil;

/**
 * Created by Lakshan Harischandra
 * Date: Sep 18, 2021
 * Time: 8:09:22 PM
 * Project: Sawiya | Volunteer
*/
@Service
public class AuthorizationServiceImpl implements AuthorizationService{
	private final Logger logger = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

	@Autowired
	private UserRepsitory userRepository;
	
	@Autowired
    private PrivilegeRepository privilegeRepository;

	@SuppressWarnings("unchecked")
	@Override
	public ResponseDTO<AuthorizeDTO> authorizeUser(String email, String password) {
		User searchedUserWithEmail = userRepository.findByEmail(email);
        ResponseDTO<AuthorizeDTO> responseDTO;
        if (Objects.isNull(searchedUserWithEmail)) {
            responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_FAILED, CommonMessages.USER_NOT_FOUND_FOR_EMAIL);
            logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_NOT_FOUND_FOR_EMAIL));
        } else {
        	if (!searchedUserWithEmail.getEnabled()) {
        		responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_FAILED, CommonMessages.USER_ACCOUNT_IS_NOT_ENABLED);
                logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_ACCOUNT_IS_NOT_ENABLED));
			}else if (SecurityUtil.matchHashedPassword(password, searchedUserWithEmail.getPassword())) {
                AuthorizeDTO authorizeData = new AuthorizeDTO();
                authorizeData.setUserDto(CommonUtil.getUserDTOFromUser(searchedUserWithEmail));
                authorizeData.setUserPrivilegesMap(getUserPrivileges(searchedUserWithEmail.getRoleId().getRoleId()));
                responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_SUCCESS, CommonMessages.USER_AUTHORIZED_AND_PRIVILEGES_GRANTED, authorizeData);
                logger.info(LoggerUtil.setLoggerInfo(searchedUserWithEmail.getFirstName(), this.getClass().toString(), CommonMessages.USER_AUTHORIZED_AND_PRIVILEGES_GRANTED));                
            } else{
                responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_FAILED, CommonMessages.EMAIL_AND_PASSWORD_NOT_MATCHED);
                logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.EMAIL_AND_PASSWORD_NOT_MATCHED));
            }
        }
        return responseDTO;
	}	

	@Override
	public Map<Integer, String> getUserPrivileges(int roleId) {
		return privilegeRepository.findPrivilegesByRoleId(roleId).stream()
                .collect(Collectors.toMap(Privilege::getPrivilegeId, Privilege::getName));            
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseDTO<AuthorizeDTO> authorizeUserWithEmailToken(String email, String password, String emailToken) throws ParseException {
		ResponseDTO<AuthorizeDTO> responseDTO = new ResponseDTO<>();
		User searchedUserWithEmail = userRepository.findByEmail(email);
		
		if (Objects.nonNull(searchedUserWithEmail)) {
			if (!emailToken.equalsIgnoreCase(searchedUserWithEmail.getEmailToken())) {
				responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_FAILED, CommonMessages.USER_EMAIL_TOKEN_NOT_MATCHED);
				logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_EMAIL_TOKEN_NOT_MATCHED));
			} else {
				// Making user account enabled
				searchedUserWithEmail.setEnabled(Boolean.TRUE);
				userRepository.save(searchedUserWithEmail);
				responseDTO = this.authorizeUser(email, password);
			}
		}else {
			responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_FAILED, CommonMessages.USER_NOT_FOUND_FOR_EMAIL);
            logger.warn(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_NOT_FOUND_FOR_EMAIL));
		}		
		return responseDTO;
	}

}


