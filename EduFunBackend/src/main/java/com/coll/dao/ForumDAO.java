package com.coll.dao;

import java.util.List;


import com.coll.model.Forum;

public interface ForumDAO 
{
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public List<Forum> listForums();
	public boolean updateForum(Forum forum);
}
