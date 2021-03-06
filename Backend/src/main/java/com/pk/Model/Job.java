package com.pk.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table
@SequenceGenerator(name="jobidseq",sequenceName="jobid_seq")
public class Job 
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobidseq")
	 int jobId;
	 
	 String designation;
	 String description;
	 String companyName;
     String location;
     @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	 int ctc;
	 Date lastdateforApply;
	 String skills;
	 public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public Date getLastdateforApply() {
		return lastdateforApply;
	}
	public void setLastdateforApply(Date lastdateforApply) {
		this.lastdateforApply = lastdateforApply;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
}
