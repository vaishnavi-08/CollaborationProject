package com.coll.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.JobDAO;
import com.coll.model.Job;
@RestController
public class JobRestController 
{
	@Autowired
	JobDAO jobDAO;
	@PostMapping("/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		if(jobDAO.addJob(job)) {
			return new ResponseEntity<String>("Job Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Job not Added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getJob/{jobId}")
	public ResponseEntity<Job> getJob(@PathVariable("jobId") int jobId)
	{
		Job job1=jobDAO.getJob(jobId);
		if(job1!=null)
		{
			return new ResponseEntity<Job>(job1,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Job>(job1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
