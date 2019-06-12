package com.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDao;
import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobDAOTestCase {
	static JobDAO jobDAO;
	@BeforeClass
	public static void initialise()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		job.setDesignation("Programmer");
		job.setCompanyName("BlueSoft InfoTech");
		job.setJobDesc("Need to have end to end Java Stock Knowledge");
		job.setCTC(500000);
		job.setSkill("Java,Spring,Hibernate");
		job.setJobLocation("Pune");
		job.setLastDateToApply(new java.util.Date(2019,05,30));
		assertTrue("Job added succesfully",jobDAO.addJob(job));
	}
	//@Test
	//public void ShowJobTest()
	//{
		//List<Job> jobList=JobDAO.showJobs();
		//assertTrue("Problem in showing jobs",jobList.size()>0);
		//for(Job job:jobList)
		//{
			//System.out.println(job.getDesignation()+"::::");
			//System.out.println(job.getJobDesc()+"::::");
			//System.out.println(job.getCompanyName()+"::::");
			//System.out.println(job.getLastDateToApply()+"::::");
		//}
	@Test
	public void getJobTest()
	{
		Job job=jobDAO.getJob(953);
		assertNotNull("There is no such job with jobId",job);
		job.getJobId();
		job.getJobDesc();
		job.getDesignation();
		job.getCompanyName();
		job.getLastDateToApply();
	}
}