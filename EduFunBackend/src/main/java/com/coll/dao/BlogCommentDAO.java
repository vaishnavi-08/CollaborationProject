package com.coll.dao;

import java.util.List;

import com.coll.model.BlogComment;

public interface BlogCommentDAO 
{
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(int commentId);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> listBlogComment(int blogId);
}
