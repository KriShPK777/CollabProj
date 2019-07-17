package CollProj.Backend.Dao;

import java.util.List;

import CollProj.Backend.Model.Job;

public interface JobDAO 
{ 
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public List<Job> displayJob();
	public Job getJobDetails(int jobId);
	
}
