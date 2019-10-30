package com.bit.authentication.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.authentication.controller.CEncrypt;
import com.bit.authentication.dao.SmsDao;
import com.bit.authentication.vo.SmsVo;

import kr.co.youiwe.webservice.ServiceSMSSoapProxy;



@Controller
public class SmsController {
	@Autowired
	private SmsDao dao;
	
	@ResponseBody
	@RequestMapping(value = "/joinMember", method = RequestMethod.POST)
	public String joinMember(SmsVo m)
	{
		String str = "";
		str = dao.join(m)+"";
		return str;
	}
	
	public void setDao(SmsDao dao) {
		this.dao = dao;
	}

	@ResponseBody
	@RequestMapping("/sendAuthNum")
	public String sendAuthNum(String tel)
	{
		String r = "";
		//System.out.println(tel);
		//난수발생
		Random rd = new Random();
		for(int i=1;i<=10;i++)
		{
			r+=rd.nextInt(10)+"";
		}
		
		String str = "";
		String smsID= "rola";	
		String smsPW="bit123400";
		//01025598279
		
		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		
		try{
			String senderPhone = "01025598279";
			String receivePhone=tel;
			String smsContent = "인증번호는"+"["+r+"] 입니다.";
			String test1 = (smsID+smsPW+receivePhone);
			CEncrypt encrypt = new CEncrypt("MD5",test1);
			java.lang.String send = sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
	 		System.out.println("결과:"+send);
	 		str = send;
			}catch(Exception e){
			System.out.println("Exception in main:" +e);
			}
		
		
		return r;
	}
	
	@RequestMapping(value = "smssend.do", 
			method = RequestMethod.GET)
	public void form()
	{		
	}
	
	@ResponseBody
	@RequestMapping(value = "smssend.do", 
			method = RequestMethod.POST)
	public String submit(String senderPhone,String receivePhone,String smsContent)
	{
		String str = "";
		String smsID= "rola";	
		String smsPW="bit123400";
		//01025598279
		
		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try{
		
		String test1 = (smsID+smsPW+receivePhone);
		CEncrypt encrypt = new CEncrypt("MD5",test1);
		java.lang.String send = sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
 		System.out.println("결과:"+send);
 		str = send;
		}catch(Exception e){
		System.out.println("Exception in main:" +e);
		}
		return str;
	}
}
