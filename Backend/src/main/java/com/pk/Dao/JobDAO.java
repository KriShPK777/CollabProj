package com.pk.Dao;

import java.util.List;

import com.pk.Model.Job;

public interface JobDAO 
{ 
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public List<Job> displayJob();
	public Job getJobDetails(int jobId);
	
}
