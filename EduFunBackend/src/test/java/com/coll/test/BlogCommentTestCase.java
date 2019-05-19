package com.coll.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

public class BlogCommentTestCase
{
	static BlogCommentDAO blogCommentDAO;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogcommentDAO");
	}
	@Test
	public void addBlogCommentTest()
	{
		BlogComment comment=new BlogComment();
		comment.setBlogId(954);
		comment.setcommentData("The blog about web technologies");
		comment.setCreateDate(new java.util.Date());
		comment.setUsername("Tarun");
		assertTrue("Problem in adding comment:",blogCommentDAO.addBlogComment(comment));
	}
}
