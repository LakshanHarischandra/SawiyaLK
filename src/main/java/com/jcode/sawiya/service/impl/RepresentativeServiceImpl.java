package com.jcode.sawiya.service.impl;


import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.repository.RepresentativeRepository;
import com.jcode.sawiya.repository.UserRepsitory;
import com.jcode.sawiya.service.RepresentativeService;
import com.jcode.sawiya.service.UserRegService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Objects;

/**
 * Created by Thakshila Bandara
 * Date: Dec 27, 2023.
 * Time: 9:45:02 AM
 * Project: Sawiya | Volunteer
 */
@Service
public class RepresentativeServiceImpl implements RepresentativeService {

    @Autowired
    private RepresentativeRepository representativeRepository;

    @Override
    public ResponseDTO representativeRegister() throws ParseException{



        representativeRepository.save(CommonUtil.getRepresentativeFromRepresentativeDTO());

        return ResponseDTO.builder().
                message(CommonMessages.REPRESENTATIVE_REGISTERED_SUCCESSFULLY).
                successOrFail(CommonMessages.RESPONSE_DTO_SUCCESS).
                build();

    }

}
