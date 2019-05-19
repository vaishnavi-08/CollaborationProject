
package com.coll.dao;

import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Job;
@Repository("JobDAO")
@Transactional
public class JobDAOImpl implements JobDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public List<Job> getAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		org.hibernate.query.Query query=session.createQuery("from JobDesc");
		List<Job> joblist=query.list();
		session.close();
		return joblist;
		
	}

	
	public Job getJob(int id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job)session.get(Job.class, id);
		session.close();
		return job;
	}

}
