package com.jcode.sawiya.dto;

import java.io.Serializable;
import java.util.Map;


/**
 * Created by Lakshan Harischandra
 * Date: Apr 8, 2022
 * Time: 9:01:28 PM
 * Project: Sawiya | Volunteer
*/
public class AuthorizeDTO implements Serializable {
    private UserDTO userDto;
    private Map<Integer, String> userPrivilegesMap;
    
	public UserDTO getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	public Map<Integer, String> getUserPrivilegesMap() {
		return userPrivilegesMap;
	}
	public void setUserPrivilegesMap(Map<Integer, String> userPrivilegesMap) {
		this.userPrivilegesMap = userPrivilegesMap;
	}
}


