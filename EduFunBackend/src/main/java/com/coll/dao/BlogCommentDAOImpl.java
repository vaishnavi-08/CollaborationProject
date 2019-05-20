package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.BlogComment;

@Transactional
@Repository("blogcommentDAO")

public class BlogCommentDAOImpl implements BlogCommentDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}


	public boolean deleteBlogComment(int commentId) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(commentId);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}


	public BlogComment getBlogComment(int commentId) {
		Session session=sessionFactory.openSession();
		BlogComment blogComment=session.get(BlogComment.class,commentId);
		session.close();
		return blogComment;
	}

	
	public List<BlogComment> listBlogComment(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from blogComment where blogId=:blogId");
		query.setParameter("blogId",blogId);
		List<BlogComment> commentList=query.list();
		session.close();
		return commentList;
	}
}
