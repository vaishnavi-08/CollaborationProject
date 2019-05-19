package com.coll.dao;

import java.util.List;


import com.coll.model.ForumComment;

public interface ForumCommentDAO {
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(int commentId);
	public List<ForumComment> listForumComment(int blogId);
}
