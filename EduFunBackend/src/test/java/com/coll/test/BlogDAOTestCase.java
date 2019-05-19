package com.coll.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

public class BlogDAOTestCase
{
	static BlogDAO blogDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("JavaEE");
		blog.setBlogContent("");
		blog.setCreateDate(new java.util.Date());
		blog.setUsername("Tarun");
		blog.setDislikes(0);
		blog.setLikes(1);
		blog.setStatus("NA");
		assertTrue("Problem in adding blog:",blogDAO.addBlog(blog));
	}
}
