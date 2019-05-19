package com.coll.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.ForumComment;

@Repository("ForumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteForumComment(int commentId) {
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

	public List<ForumComment> listForumComment(int commentId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from forumComment where commentId=:commentId");
		query.setParameter("commentId", commentId);
		List<ForumComment> commentList=((org.hibernate.query.Query) query).list();
		session.close();
		return commentList;
	}

}
