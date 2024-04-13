package com.jcode.sawiya.util;

import javax.validation.ConstraintViolationException;

/**
 * Created by Thakshila Bandara
 * Date: Dec 6, 2023
 * Time: 6.49.45 PM
 * Project: Sawiya | Volunteer
 */
public class InputValidationUtil {

    public static boolean isValidTitle(String title){

        return title.equals("Mr") || title.equals("Mrs") || title.equals("Miss") || title.equals("Venerable");
    }

    public static boolean isValidNic(String nic){

        return nic.matches("^[0-9]{9}[vV]$") || nic.matches("^[0-9]{7}[0][0-9]{4}$");
    }
}
