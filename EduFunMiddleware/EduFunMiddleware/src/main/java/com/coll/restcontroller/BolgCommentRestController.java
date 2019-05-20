package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

@RestController
public class BolgCommentRestController {
	@Autowired
	BlogCommentDAO blogCommentDAO;
	@GetMapping("/listBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>> listBlogComments(@PathVariable("blogId")int blogId)
	{
		List<BlogComment> listBlogComments=blogCommentDAO.listBlogComment(blogId);
		if(listBlogComments.size()>0)
		{
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	@PostMapping("/addBlogComment")
	public ResponseEntity<String> addBlogComments(@RequestBody BlogComment blogcomment)
	{
		if(blogCommentDAO.addBlogComment(blogcomment))
		{
			return new ResponseEntity<String>("Blog Comment added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Blog Comment not added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getBlogComment/{commentId}")
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("commentId")int commentId)
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
		if(blogComment!=null)
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteBlogComment/{commentId}")
	public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId")int commentId)
	{
		if(blogCommentDAO.deleteBlogComment(commentId))
		{
			return new ResponseEntity<String>("Comment deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Comment not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
