package com.bit.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bit.authentication.controller.CEncrypt;
import com.bit.authentication.dao.SmsDao;
import com.bit.authentication.vo.SmsVo;

import kr.co.youiwe.webservice.ServiceSMSSoapProxy;
@Component
public class MailComponent {
	
	@Autowired
	private MailSender javaMailSender;
	
	
	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	private SmsDao dao;
	
	public void setDao(SmsDao dao) {
		this.dao = dao;
	}
	//@Scheduled(cron="0 12,13,14 * 1-30 * ?")
	public void a()
	{
		System.out.println("aaaa");
	}
	
	//@Scheduled(cron="0 43,44 * 1-30 * ?")
	public void send()
	{
		List<SmsVo> list = dao.listAll();
		for(SmsVo m   :list)
		{
			//sendSMS(m);	
			sendEmail(m);
			System.out.println(m.getEmail());
			//System.out.println(m.getPhone());
		}
	}
	
	public void sendEmail(SmsVo m)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setSubject("명세서발송");
		msg.setFrom("saige23@naver.com");
		msg.setText("이번달 요금은:"+m.getPay()+"원입니다.");
		msg.setTo(m.getEmail());
		try {
			javaMailSender.send(msg);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public void sendSMS(SmsVo m)
	{
		String smsID= "rola";	
		String smsPW="bit123400";
		//01025598279
		String receivePhone = m.getPhone();
		String senderPhone = "01025598279";
		String smsContent = "이번달 요금은 " + m.getPay() + "입니다.";
		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try{
		
		String test1 = (smsID+smsPW+receivePhone);
		CEncrypt encrypt = new CEncrypt("MD5",test1);
		java.lang.String send = sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
 		System.out.println("결과:"+send);
 		
		}catch(Exception e){
		System.out.println("Exception in main:" +e);
		}
	}
	
}
