package com.bit.bookStore;

import java.util.HashMap;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SmtpComponent {
	@Bean
	public JavaMailSenderImpl  javaMailSender()
	{
		JavaMailSenderImpl ob = new JavaMailSenderImpl();
		ob.setHost("smtp.naver.com");
		ob.setPort(465);
		ob.setUsername("saige23@naver.com");
		ob.setPassword("");
		ob.setProtocol("smtps");
		ob.setDefaultEncoding("UTF-8");
		
		Properties prop = new Properties();
	
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.auth",true);
		prop.put("mail.smtp.ssl.checkserveridentity", true);
		prop.put("mail.smtp.ssl.trust", "*");
		
		ob.setJavaMailProperties(prop);
		
		return ob;
	}
	
}
