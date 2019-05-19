package com.coll.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.UserDetailDAO;
import com.coll.model.UserDetail;

@RestController
public class UserRestController {
		@Autowired
		UserDetailDAO userDetailDAO;
		@PostMapping("/registerUser")
		public ResponseEntity<String> registerUser(@RequestBody UserDetail user)
		{
			if(userDetailDAO.registerUser(user))
			{
				return new ResponseEntity<String>("User Data register",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("User Data not registered",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PostMapping("/updateUser")
		public ResponseEntity<UserDetail> updateUser(@RequestBody UserDetail user)
		{
			if(userDetailDAO.updateUser(user)) 
			{
				return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<UserDetail>(user,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/checkUser")
		public ResponseEntity<UserDetail> checkUser(@RequestBody UserDetail user,HttpSession session)
		{
			UserDetail user1=userDetailDAO.checkUser(user);
			if(user1!=null)
			{
				session.setAttribute("userDetail", user1);
				return new ResponseEntity<UserDetail>(user1,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<UserDetail>(user1,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/getUser/{username}")
		public ResponseEntity<UserDetail> getUser(@PathVariable("username")String username)
		{
			UserDetail user=userDetailDAO.getUser(username); 
			if(user!=null)
			{
				return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<UserDetail>(user,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
