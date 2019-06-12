package com.coll.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDao;
import com.coll.model.Friend;

public class FriendDAOTestCase 
{
	static FriendDao friendDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		friendDAO=(FriendDao)context.getBean("friendDAO");
	}
	@Test
	public void sendFriendRequest()
	{
		Friend friend=new Friend();
		friend.setUsername("vinod");
		friend.setFriendusername("ramesh");
		assertTrue("problem in adding friend",friendDAO.sendFriendRequest(friend));
	}
	@Test
	public void acceptFriendRequestTest()
	{ 
		//table required to be created
	}
	@Test
	public void deleteFriendRequestTest()
	{
		//table required to be created
	}
	@Test
	public void showFriendList()
	{
		List<Friend> friendList=friendDAO.showFriendList("vinod");
		assertTrue("Problem in showing friendlist",friendList.size()<=0);
		for(Friend friend:friendList)
		{
			System.out.print(friend.getUsername()+"::::");
			System.out.println(friend.getFriendusername());
			
		}
	}
	@Test
	public void showPendingFriendListTest()
	{
		//List<Friend> pendingFriendList=friendDAO.showPendingFriendList("punit");
		//assertTrue("problem in showing pending friend list",pendingFriendList.size()>0);
		//for(Friend friend:pendingFriendList)
		//{
			//System.out.print(friend.getUsername()+"::::");
			//System.out.println(friend.getFriendusername());
		//}
	}
}
