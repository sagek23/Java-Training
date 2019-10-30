package com.bit.bookStore.Controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.bookStore.dao.MailDao;
import com.bit.bookStore.vo.MailVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MailController {
	//@Autowired
	//private MailSender javaMailSender;

	//public void setJavaMailSender(MailSender javaMailSender) {
	//	this.javaMailSender = javaMailSender;
	//}
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
	@ResponseBody
	@RequestMapping("/mail")
	public String mailList()
	{
		String str = "";
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
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
	@RequestMapping("/mail.do")
	public String mail()
	{
		String r="";
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setSubject("회원가입안내");
		smm.setFrom("saige23@naver.com");
		smm.setText("회원가입축하");
		smm.setTo("saige23@naver.com");
		try {
			//javaMailSender.send(smm);
			javaMailSender.send(new MimeMessagePreparator() {
				   public void prepare(MimeMessage mimeMessage) throws MessagingException {
				     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				     message.setFrom("saige23@naver.com");
				     message.setTo("saige23@naver.com");
				     message.setSubject("my subject");
				     message.setText("my text <img src='cid:myLogo'>", true);
				     message.addInline("myLogo", new ClassPathResource("com/bit/bookStore/img/picachu.png"));
				   }
				 });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return r;
	}
	
}
