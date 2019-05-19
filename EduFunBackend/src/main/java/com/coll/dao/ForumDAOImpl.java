package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Forum;

@Repository("ForumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	public List<Forum> listForums() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from forum");
		List<Forum> forumList=query.list();
		session.close();
		return forumList;
	}

	public boolean updateForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	

}
