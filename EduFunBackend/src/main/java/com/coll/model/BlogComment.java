package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
@SequenceGenerator(name="blogcommentid_seq",sequenceName="blogcommentIdSeq")
public class BlogComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogcommentgid_seq")
	int commentId;
	int blogId;
	String commentData;
	String username;
	Date createDate;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getcommentData() {
		return commentData;
	}
	public void setcommentData(String commentData) {
		this.commentData = commentData;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
