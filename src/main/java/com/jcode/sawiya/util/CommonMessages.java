package com.jcode.sawiya.util;

/**
 * Created by Lakshan Harischandra
 * Date: Apr 8, 2022
 * Time: 9:51:34 PM
 * Project: Sawiya | Volunteer
*/
public class CommonMessages {
	/*
    Message declarations - User
    */
    public static final String DUMMY_NOT_PROVIDED = "Not provided";    
    public static final String RESPONSE_DTO_SUCCESS = "Success";    
    public static final String RESPONSE_DTO_FAILED = "Failed";
    public static final String USER_SAVED_SUCCESSFULLY = "User saved successfully.";
    public static final String USER_SAVED_FAILED = "Something went wrong when registering user.";
	public static final String EXCEPTION_OCCURED = "Exception detected";
    public static final String USER_EMAIL_ALREADY_EXISTS = "User email already exists";
    public static final String INVALID_TITLE = "Invalid user title";
    public static final String INVALID_NIC = "Invalid NIC number";
    public static final String USER_NOT_FOUND_FOR_EMAIL = "There's no such User exists in the System";
    public static final String USER_AUTHORIZED_AND_PRIVILEGES_GRANTED = "User Identified and Privileges are Granted";
    public static final String EMAIL_AND_PASSWORD_NOT_MATCHED = "Email and Password are not matched for the User";
    public static final String USER_REGISTERED_SUCCESSFULLY = "User registered successfully.";
    public static final String USER_REGISTERED_FAILED = "Something went wrong when registering the user.";
    public static final String REPRESENTATIVE_REGISTERED_SUCCESSFULLY = "Representative registered successfully.";
    public static final String USER_EMAIL_TOKEN_NOT_MATCHED = "Something went wrong with the Email verification, Please re-check.";
    public static final String USER_ACCOUNT_IS_NOT_ENABLED = "Please verify your email before sign in, an email has been sent to your inbox.";
    public static final String USER_REGITRATION_EMAIL_HEADER = "Confirm Your Email Account with Sawiya!";
    public static final String USER_REGITRATION_EMAIL_SENT_SUCCESS = "An Email has been sent to the relavant user!";
    public static final Integer DEFAULT_USER_RATING = 0;

    /*
    Message declarations - Role
    */
    public static final String ROLE_USER = "User";
    public static final String ROLE_REPRESENTATIVE = "Representative";
    
    /*
    Message declarations - Representative
     */
    public static final String REPRESENTATIVE_DEFAULT_RETIRED_DATE = "31.12.9999";

}


