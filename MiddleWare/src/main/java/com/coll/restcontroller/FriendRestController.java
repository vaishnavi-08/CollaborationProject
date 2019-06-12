package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.FriendDao;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

@RestController
public class FriendRestController 
{
	@Autowired
	FriendDao friendDAO;
	@GetMapping(value="/showFriendList/{username}")
	public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username")String username)
	{
		List<Friend> friendList=friendDAO.showFriendList(username);
		if(friendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/suggestedFriendList/{username}")
	public ResponseEntity<List<UserDetail>> suggestedPendingFriendList(@PathVariable("username")String username)
	{
		List<UserDetail> suggestedFriendList=friendDAO.showSuggestedFriend(username);
		if(suggestedFriendList.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(suggestedFriendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(suggestedFriendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/pendingFriendList/{username}")
	public ResponseEntity<List<Friend>> showPendingFriendList(@PathVariable("username")String username)
	{
		List<Friend> pendingFriendList=friendDAO.showPendingFriendList(username);
		if(pendingFriendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(pendingFriendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(pendingFriendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId")int friendId)
	{
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend Request accepted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in accepting Friend Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId")int friendId)
	{
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend Request rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in rejecting Friend Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/sendFriendRequest/")
	public ResponseEntity<String> sendFriendRequest(Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Friend Request sent",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in sending Friend Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}