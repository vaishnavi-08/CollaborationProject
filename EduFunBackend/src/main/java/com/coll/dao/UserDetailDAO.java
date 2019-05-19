package com.coll.dao;

import com.coll.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail checkUser(UserDetail user);
	public UserDetail getUser(String username);
}
