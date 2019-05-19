package com.coll.dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO 
{
	boolean addJob(Job job);
	List<Job> getAllJobs();
	Job getJob(int id);
}
