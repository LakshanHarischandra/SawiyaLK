package com.jcode.sawiya.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jcode.sawiya.service.EmailService;

/**
 * Created by Lakshan Harischandra
 * Date: Feb 02, 2024
 * Time: 8:08:40 PM
 * Project: Sawiya | Volunteer
*/
@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void sendEmail(String from, String to, String header, String body) throws MessagingException {
		MimeMessage emailMsg = mailSender.createMimeMessage();
		emailMsg.setFrom(from);
		emailMsg.setRecipients(MimeMessage.RecipientType.TO, to);
		emailMsg.setSubject(header);		
		emailMsg.setContent(body, "text/html; charset=utf-8");
		mailSender.send(emailMsg);		
	}

}
