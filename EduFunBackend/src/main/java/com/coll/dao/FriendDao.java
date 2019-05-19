package com.coll.dao;

import java.util.List;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

public interface FriendDao 
{
	List<UserDetail> listOfSuggestedUsers(String email);
	boolean addFriendRequest(Friend friend);
	List<Friend> getAllPendingRequests(String email);
	void updateFriendRequest(Friend friend);
	List<UserDetail> listOfFriends(String email);
}