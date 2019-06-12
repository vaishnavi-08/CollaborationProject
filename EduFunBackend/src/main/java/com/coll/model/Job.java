package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job 
{
	@Id
	int jobId;
	int CTC;
	String Skill;
	Date lastDateToApply;
	String jobLocation;
	String jobDesc;
	String qualification;
	String designation;
	String CompanyName;
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getSkill() {
		return Skill;
	}
	public void setSkill(String skill) {
		Skill = skill;
	}
	public Date getLastDateToApply() {
		return lastDateToApply;
	}
	public void setLastDateToApply(Date lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public int getCTC() {
		return CTC;
	}
	public void setCTC(int cTC) {
		CTC = cTC;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	String status;
	int salary;
	int yrsExp;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getYrsExp() {
		return yrsExp;
	}
	public void setYrsExp(int yrsExp) {
		this.yrsExp = yrsExp;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
