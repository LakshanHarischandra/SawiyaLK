package com.jcode.sawiya.service.impl;

import com.jcode.sawiya.dto.RepresentativeDTO;
import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.model.Representative;
import com.jcode.sawiya.repository.RepresentativeRepository;
import com.jcode.sawiya.service.RepresentativeService;
import com.jcode.sawiya.util.CommonMessages;
import com.jcode.sawiya.util.CommonUtil;
import com.jcode.sawiya.util.LoggerUtil;
import com.jcode.sawiya.util.ResponseUtil;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentativeServiceImpl implements RepresentativeService {
	
    @Autowired
    private RepresentativeRepository representativeRepository;

    @Override
    public ResponseDTO registerRepresentative() throws ParseException{    	
    	ResponseDTO<RepresentativeDTO> responseDTO;
    	Representative representative = representativeRepository.save(CommonUtil.getRepresentativeFromRepresentativeDTO());
    	responseDTO = ResponseUtil.getResponseDto(CommonMessages.RESPONSE_DTO_SUCCESS, CommonMessages.REPRESENTATIVE_REGISTERED_SUCCESSFULLY, representative);
    	return responseDTO;
    }

}
