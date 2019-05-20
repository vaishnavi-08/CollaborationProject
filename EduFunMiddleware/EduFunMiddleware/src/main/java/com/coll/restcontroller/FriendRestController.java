package com.coll.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.FriendDao;

@RestController
public class FriendRestController 
{
	@Autowired
	FriendDao friendDAO;
	
}
