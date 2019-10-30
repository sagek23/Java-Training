package com.bit.bookStore.dao;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.bit.bookStore.db.DBManager;
import com.bit.bookStore.vo.MailVo;

@Repository
public class MailDao {
	

	 public void cornTest() 
	 {
	        System.out.println("메일 발송");
	 }

	public List<MailVo> listMail()
	{
		return DBManager.listMail();
	}
}
