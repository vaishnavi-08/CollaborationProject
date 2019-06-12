
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

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

@RestController
public class BlogRestController 
{
	@Autowired
	BlogDAO blogDAO;
	@GetMapping("/showAllBlogs")
	public ResponseEntity<List<Blog>> showAllBlogs()
	{
		List<Blog> blogList=blogDAO.listBlogs();
		if(blogList.size()>0)
		{
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislikes(0);
		blog.setStatus("NA");
		blog.setUsername("Sudhir");
		if(blogDAO.addBlog(blog)) 	
		{
			return new ResponseEntity<String>("blog added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("problem occured in blog adding",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.deleteBlog(blog)) {
			return new ResponseEntity<String>("blog deleted",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("probliem in deleting blog",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId")int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.incLikes(blog)) {
			return new ResponseEntity<String>("likes incremented",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("problem in incrementing likes",HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	@GetMapping("/incrementDisLikes/{blogId}")
	public ResponseEntity<String> decrementLikes(@PathVariable("blogId")int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.incDisLikes(blog)) {
			return new ResponseEntity<String>("likes decremented",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("problem in decrementing likes",HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	@GetMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.approveBlog(blog)) {
			return new ResponseEntity<String>("blog approved",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("problem in approving blog",HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.rejectBlog(blog)) {
			return new ResponseEntity<String>("blog rejected",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("problem in rejecting blog",HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	@GetMapping("/getBlog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blog!=null) {
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Blog>(blog,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	@PostMapping("/updateBlog/{blogId}")
	public ResponseEntity<String> updateBlog(@PathVariable("blogId")int blogId)
	{
		
		return null;
}
}