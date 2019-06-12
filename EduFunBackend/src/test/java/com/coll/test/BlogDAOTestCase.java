package com.coll.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

import jdk.nashorn.internal.ir.annotations.Ignore;

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
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("AngularJS");
		blog.setBlogContent("");
		blog.setCreateDate(new java.util.Date());
		blog.setUsername("Punit");
		blog.setDislikes(5);
		blog.setLikes(30);
		blog.setStatus("NA");
		assertTrue("Problem in adding blog:",blogDAO.addBlog(blog));
	}
	@Test 
	public void approveBlogTest()
	{
	
	}
	@Test
	public void incLikesTest()
	{
		
	}
	@Test
	public void incDisLikesTest()
	{
		
	}
	@Test
	public void rejectBlogTest()
	{
		
	}
}
