package com.coll.dao;

import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.UserDetail;

@Repository("UserDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean registerUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	public boolean updateUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	public UserDetail checkUser(UserDetail user) {
		Session session=sessionFactory.openSession();
		org.hibernate.query.Query query=session.createQuery("from UserDetail where username=:username and password=:password");
		query.setParameter("username",user.getUsername());
		query.setParameter("password",user.getPassword());
		List<UserDetail> listUser=query.list();
		if(listUser.size()>0)
		{
			return listUser.get(0);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,username);
		session.close();
		return null;
	}
	
	

}
