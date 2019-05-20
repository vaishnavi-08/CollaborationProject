package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Blog getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog=session.get(Blog.class,blogId);
		session.close();
		return blog;
	}

	public List<Blog> listBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> bloglist=query.list();
		session.close();
		return bloglist;
	}

	public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean incLikes(Blog blog) {
		try
		{
			blog.setLikes(blog.getLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean incDisLikes(Blog blog) {
		try
		{
			blog.setDislikes(blog.getDislikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

}
