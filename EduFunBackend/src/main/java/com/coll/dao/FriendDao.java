package com.coll.dao;

import java.util.List;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

public interface FriendDao 
{
	public boolean addFriendRequest(Friend friend);
	public boolean deleteFriendRequest(Friend friend);
	public void updateFriendRequest(Friend friend);
	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);
	public List<UserDetail> showSuggestedFriend(String loginName);
	public List<Friend> showPendingFriendList(String loginName);
	List<Friend> getAllPendingRequests(String email);
	List<UserDetail> listOfFriends(String email);
	public List<Friend> showFriendList(String loginName);
	
	
	
	
	
}
