package com.bit.bookStore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bit.bookStore.dao.MailDao;
import com.bit.bookStore.vo.MailVo;

@Component
public class BitMailComponent {

		@Autowired
		private JavaMailSender javaMailSender;
		
		public void setJavaMailSender(JavaMailSender javaMailSender) {
			this.javaMailSender = javaMailSender;
		}
		@Autowired
		MailDao dao = new MailDao();
		
		public void setDao(MailDao dao) {
			this.dao = dao;
		}
	
	//@Scheduled(cron = "0 0,2,4,6,58 * 1-30 * ?/r/n")
	public void sendMail() {
		SimpleMailMessage smm = new SimpleMailMessage();
		try {
			smm.setSubject("요금명세서");
			smm.setFrom("saige23@naver.com");
			
			List<MailVo> list = dao.listMail();
			for(MailVo m:list)
			{
				smm.setTo(m.getEmail());
				smm.setText("이번달 요금은 "+m.getPay()+"입니다");
				javaMailSender.send(smm);
				System.out.println(m.getEmail()+"에게 메일발송");
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
