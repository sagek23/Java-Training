package com.bit.exam09;

public class WriteArticleServiceImp {
	ArticleDao articleDao;


	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	
	public void insert()
	{
		articleDao.insert();
	}
}