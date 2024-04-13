package com.jcode.sawiya.util;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import com.jcode.sawiya.dto.RepresentativeDTO;
import com.jcode.sawiya.dto.UserDTO;
import com.jcode.sawiya.model.Representative;
import com.jcode.sawiya.model.Role;
import com.jcode.sawiya.model.User;


/**
 * Created by Lakshan Harischandra
 * Date: Apr 8, 2022
 * Time: 9:32:21 PM
 * Project: Sawiya | Volunteer
*/
public class CommonUtil {

    private static SecurityUtil securityUtil;

	public static User getUserWithDummyData(User user) throws Exception {
        if (Objects.nonNull(user)) {        	
            user.setAddressLineOne(CommonMessages.DUMMY_NOT_PROVIDED);
            user.setAddressLineTwo(CommonMessages.DUMMY_NOT_PROVIDED);
            user.setCity(CommonMessages.DUMMY_NOT_PROVIDED);
            user.setPostalCode(CommonMessages.DUMMY_NOT_PROVIDED);
            user.setCountry(CommonMessages.DUMMY_NOT_PROVIDED);
            user.setNic(CommonMessages.DUMMY_NOT_PROVIDED);            
            user.setRoleId(new Role(3));
        	user.setPassword(SecurityUtil.hashPassword(user.getPassword()));        	        	
            return user;
        }
        return null;
    }
	
	public static UserDTO getUserDTOFromUser(User user) {
        if (Objects.nonNull(user)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setTitle(user.getTitle());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setGender(user.getGender());
            userDTO.setAddressLineOne(user.getAddressLineOne());
            userDTO.setAddressLineTwo(user.getAddressLineTwo());
            userDTO.setCity(user.getCity());
            userDTO.setPostalCode(user.getPostalCode());
            userDTO.setCountry(user.getCountry());
            userDTO.setEmail(user.getEmail());
            userDTO.setContactNumber(user.getContactNumber());
            userDTO.setPassword(user.getPassword());
            userDTO.setNic(user.getNic());
            userDTO.setEmailToken(user.getEmailToken());
            userDTO.setEnabled(user.getEnabled());
            userDTO.setAgreedOn(user.getAgreedOn());
            userDTO.setUserRating(user.getUserRating());
            userDTO.setRoleId(user.getRoleId().getRoleId());            
            return userDTO;
        }
        return null;
    }

    public static User getUserFromUserDTO(UserDTO userDTO) throws ParseException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getDefault());
        String agreedOn = dateFormat.format(date);

        Date parsedAgreedOn = dateFormat.parse(agreedOn);

            if (Objects.nonNull(userDTO)) {

                User user = new User();
                user.setTitle(userDTO.getTitle());
                user.setFirstName(userDTO.getFirstName());
                user.setLastName(userDTO.getLastName());
                user.setGender(userDTO.getGender());
                user.setAddressLineOne(userDTO.getAddressLineOne());
                user.setAddressLineTwo(userDTO.getAddressLineTwo());
                user.setCity(userDTO.getCity());
                user.setPostalCode(userDTO.getPostalCode());
                user.setCountry(userDTO.getCountry());
                user.setEmail(userDTO.getEmail());
                user.setContactNumber(userDTO.getContactNumber());
                user.setPassword(securityUtil.hashPassword(userDTO.getPassword()));
                user.setNic(securityUtil.hashPassword(userDTO.getNic()));
                user.setEmailToken(SecurityUtil.generateToken());
                user.setEnabled(userDTO.isEnabled());
                user.setAgreedOn(parsedAgreedOn);
                user.setUserRating(CommonMessages.DEFAULT_USER_RATING);
                user.setRoleId(new Role(userDTO.getRoleId()));
                return user;
            }


        return null;

    }

    public static Representative getRepresentativeFromRepresentativeDTO() throws ParseException{

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getDefault());
        String appointedOn = dateFormat.format(date);

        Date parsedAppointedOn = dateFormat.parse(appointedOn);

        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date retiredOn = dateFormat.parse(CommonMessages.REPRESENTATIVE_DEFAULT_RETIRED_DATE);

        Representative representative = new Representative();

        representative.setAppointedOn(parsedAppointedOn);
        representative.setRetiredOn(retiredOn);

        return representative;

    }
    
    public static String generateEmailBodyWithToken(String userName, String token) {
    	String content= null;
        if (Objects.nonNull(token) && Objects.nonNull(userName)) {
            content = "<b>Dear "+userName+",</b>"
            		+ "<br>"
            		+ "<p>Thank you for registering with Sawiya.lk <br><br>This is an auto generated email for your email confirmation. "
            		+ "<br>Please click on the following link and login to the application for complete your registration! "
            		+ "</br>"
            		+ " <a href=\"http://localhost:8086/confirm/email/?token="+token+"\" target=\"_blank\"> <br><b>Click here to verify the account </b></a></p>"
            		+ "<br>"
            		+ "<i>Best Regards,</i>"
            		+ "<br>"
            		+ "<i>Team Sawiya.</i>";
        }        
		return content;
    }
}


