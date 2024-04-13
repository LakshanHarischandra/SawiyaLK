package com.jcode.sawiya.service;

import javax.mail.MessagingException;

/**
 * Created by Lakshan Harischandra
 * Date: Feb 02, 2024
 * Time: 8:08:40 PM
 * Project: Sawiya | Volunteer
*/
public interface EmailService {
	public void sendEmail(String from, String to, String header, String body) throws MessagingException;
}
