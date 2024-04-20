package com.jcode.sawiya.util;

public class InputValidationUtil {

    public static boolean isValidTitle(String title){

        return title.equals("Mr") || title.equals("Mrs") || title.equals("Miss") || title.equals("Venerable");
    }

    public static boolean isValidNic(String nic){

        return nic.matches("^[0-9]{9}[vV]$") || nic.matches("^[0-9]{7}[0][0-9]{4}$");
    }
}
