package com.pk.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.Model.Job;

@Repository ("JobDAO")
@Transactional
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addJob(Job job) 
	{
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

	@Override
	public boolean deleteJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
}

	@Override
	public List<Job> displayJob() 
	{
		Session session=sessionFactory.openSession();
		List<Job> jobList=session.createQuery("from Job").list();
		session.close();
		return jobList;
	}

	@Override
	public Job getJobDetails(int jobId) 
	{
		Session session=sessionFactory.openSession();
		Job job=(Job) session.get(Job.class, jobId);
		session.close();
		return job;
	}

}
