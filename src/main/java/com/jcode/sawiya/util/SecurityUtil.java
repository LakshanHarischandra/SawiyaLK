package com.jcode.sawiya.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.codec.Hex;

/**
 * Created by Lakshan Harischandra
 * Date: Apr 8, 2022
 * Time: 10:05:42 PM
 * Project: Sawiya | Volunteer
*/
public class SecurityUtil {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean matchHashedPassword(String password_user, String password_db) {
        return BCrypt.checkpw(password_user, password_db);
    }
    
    public static String hashToken(String token) throws NoSuchAlgorithmException{
    	MessageDigest digest = MessageDigest.getInstance("SHA-256");
    	byte[] hash = digest.digest(
    			token.getBytes(StandardCharsets.UTF_8));
    	return new String(Hex.encode(hash));		
    }
    
    public static String generateToken(){
    	SecureRandom random = new SecureRandom();
    	byte bytes[] = new byte[2000];
    	random.nextBytes(bytes);
    	return bytes.toString();	
    }
}


