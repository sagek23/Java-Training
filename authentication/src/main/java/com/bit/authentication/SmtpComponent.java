package com.bit.authentication;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SmtpComponent {
	@Bean
	public JavaMailSenderImpl  javaMailSender()
	{
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.naver.com");
		sender.setPort(465);
		sender.setUsername("saige23@naver.com");
		sender.setPassword("/");
		sender.setProtocol("smtps");
		sender.setDefaultEncoding("UTF-8");
		
		Properties prop = new Properties();
	
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.auth",true);
		prop.put("mail.smtp.ssl.checkserveridentity", true);
		prop.put("mail.smtp.ssl.trust", "*");
		
		sender.setJavaMailProperties(prop);
		
		return sender;
	}
	
}
