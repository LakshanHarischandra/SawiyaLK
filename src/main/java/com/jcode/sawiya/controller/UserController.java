package com.jcode.sawiya.controller;

import java.text.ParseException;
import java.util.Objects;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jcode.sawiya.dto.ResponseDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.service.UserService;
import com.jcode.sawiya.util.RequestEndPoints;

@RestController
@CrossOrigin(RequestEndPoints.REACT_CROSS_ORIGIN)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody 
	@PostMapping(path = RequestEndPoints.REGISTER_USER)
	public ResponseDTO<UserDTO> registerUser(@RequestBody UserDTO user){		
		ResponseDTO<UserDTO> responseDTO = new ResponseDTO<>();
		if (Objects.nonNull(user)) {
            try {
				responseDTO = userService.userRegister(user);
			} catch (ParseException | MessagingException e) {
				e.printStackTrace();
			}
        }
	    return responseDTO;
	 }

}
