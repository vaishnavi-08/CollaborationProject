package com.coll.dao;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Friend;
import com.coll.model.UserDetail;
@Repository("friendDAO")
@Transactional
public class FriendDaoImpl implements FriendDao {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addFriendRequest(Friend friend) {
		try {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		return true;
		}
		catch(Exception e) {
			return false;
		}
}
	public boolean deleteFriendRequest(Friend friend) {
		try {
		Session session=sessionFactory.getCurrentSession();
		session.delete(friend);
		return true;
		}
		catch(Exception e) {
			return false;
		}
}

	public void updateFriendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A')
			((FriendDaoImpl) session).addFriendRequest(friend);
		else
			((FriendDaoImpl) session).deleteFriendRequest(friend);
}
	
	public boolean sendFriendRequest(Friend friend) {
		try
		{
		friend.setStatus('P');
		sessionFactory.getCurrentSession().save(friend);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	

	public boolean acceptFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus('A');
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean deleteFriendRequest(int friendId)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus('N');
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<UserDetail> showSuggestedFriend(String loginName) {
		Session session=sessionFactory.openSession();
		Query query=session.createNativeQuery("select username from userdetail where username =:loginName");
		List<String> friendList=query.list();
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int i=0;
		while(i<friendList.size())
		{
			UserDetail user=session.get(UserDetail.class,friendList.get(i).toString().trim());
			listUserDetail.add(user);
			i++;
		}
		return listUserDetail;
	}
	public List<Friend> showPendingFriendList(String loginName)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from friend where (friendusername=:login1 and status='P')");
		query.setParameter("login1", loginName);
		List<Friend> pendingfriendList=query.list();
		return pendingfriendList;
	}
	
	public List<Friend> showFriendList(String loginName) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where (username=:login or friendusername=:login1) and status='A'");
		query.setParameter("login", loginName);
		query.setParameter("login1", loginName);
		List<Friend> friendList=query.list();
		return friendList;
}
	@Override
	public List<Friend> getAllPendingRequests(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserDetail> listOfFriends(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
