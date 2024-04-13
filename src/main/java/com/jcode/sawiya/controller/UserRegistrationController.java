package com.jcode.sawiya.controller;

import com.jcode.sawiya.dto.RepresentativeDTO;
import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.repository.RoleRepository;
import com.jcode.sawiya.repository.UserRepsitory;
import com.jcode.sawiya.service.RepresentativeService;
import com.jcode.sawiya.service.UserRegService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.InputValidationUtil;
import com.jcode.sawiya.util.LoggerUtil;
import com.jcode.sawiya.util.RequestEndPoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Thakshila Bandara
 * Date: Dec 04, 2023
 * Time: 8.30.00 PM
 * Project: Sawiya | Volunteer
 */
@RestController
@RequestMapping(RequestEndPoints.REGISTER_USER)
@CrossOrigin(origins = RequestEndPoints.REACT_CROSS_ORIGIN)
public class UserRegistrationController {

    private final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

    @Autowired
    private UserRegService userRegService;
    @Autowired
    private UserRepsitory userRepository;

    ResponseDTO responseDTO;

    @PostMapping
    public ResponseEntity<ResponseDTO> regUser( @RequestBody UserDTO userDTO,
                                               BindingResult bindingResult){

        if(userRepository.existsByEmail(userDTO.getEmail())){

            logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_EMAIL_ALREADY_EXISTS));
            return ResponseEntity.badRequest().body(

                    ResponseDTO.builder().
                            message(CommonMessages.USER_EMAIL_ALREADY_EXISTS).
                            successOrFail(CommonMessages.RESPONSE_DTO_FAILED).
                            build()
            );
        }

        if (bindingResult.hasErrors()) {

            List<String> errorMessages = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), errorMessages.toString()));

            return ResponseEntity.badRequest().body(
                    ResponseDTO.builder()
                            .message(errorMessages.toString())
                            .successOrFail(CommonMessages.RESPONSE_DTO_FAILED)
                            .build()
            );
        }

        try {
            if (!InputValidationUtil.isValidTitle(userDTO.getTitle())) {

                logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.INVALID_TITLE));
                return ResponseEntity.badRequest().body(
                        ResponseDTO.builder().
                                message(CommonMessages.INVALID_TITLE).
                                successOrFail(CommonMessages.RESPONSE_DTO_FAILED).
                                build()
                );
            } else if (!InputValidationUtil.isValidNic(userDTO.getNic())) {

                logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.INVALID_NIC));

                return ResponseEntity.badRequest().body(
                        ResponseDTO.builder().
                                message(CommonMessages.INVALID_NIC).
                                successOrFail(CommonMessages.RESPONSE_DTO_FAILED).
                                build()
                );
            }else {

                logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.USER_REGISTERED_SUCCESSFULLY));
                return ResponseEntity.ok().body(
                        userRegService.userRegister(userDTO)
                );
            }

        }catch(ConstraintViolationException e){

                String message = e.getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining(", "));

                logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), message));

                return ResponseEntity.badRequest().body(
                        ResponseDTO.builder().
                                message(message).
                                successOrFail(CommonMessages.RESPONSE_DTO_FAILED).
                                build()
                );

        } catch (Exception e){

            e.printStackTrace();
            logger.info(LoggerUtil.setLoggerInfoWithoutUser(this.getClass().toString(), CommonMessages.EXCEPTION_OCCURED));
            return ResponseEntity.badRequest().body(
                    ResponseDTO.builder().
                            message(e.getMessage()).
                            successOrFail(CommonMessages.RESPONSE_DTO_FAILED).
                            build()
            );
        }

    }
}
