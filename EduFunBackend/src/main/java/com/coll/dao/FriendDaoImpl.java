
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
@Repository("FriendDAO")
@Transactional
public class FriendDaoImpl implements FriendDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<UserDetail> listOfSuggestedUsers(String email) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("select username from userdetail where username=:username");
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

	
	public List<Friend> getAllPendingRequests(String email) {
	
		return null;
	}

	public void updateFriendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A')
			session.update(friend);
		else
			session.delete(friend);
}

	
	public List<UserDetail> listOfFriends(String email) {
		return null;
		
}
}
