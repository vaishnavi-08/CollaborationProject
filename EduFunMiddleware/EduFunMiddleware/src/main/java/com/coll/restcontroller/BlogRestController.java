package com.coll.restcontroller;
import com.coll.dao.BlogDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
