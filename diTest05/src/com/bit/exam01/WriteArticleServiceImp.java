package com.bit.exam01;

public class WriteArticleServiceImp {
	ArticleDao articleDao;

	public WriteArticleServiceImp(ArticleDao articleDao) {
		super();
		this.articleDao = articleDao;
	}
	public void insert()
	{
		articleDao.insert();
	}
}