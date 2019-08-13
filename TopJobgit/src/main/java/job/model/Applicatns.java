package job.model;

import java.util.Date;

public class Applicatns {
	private String JobSeakerId;
	private String JobId;
	private String  JobTitle;
	private String JobDescription;
	private Date ApplyDate;
	private String Status;
	public String getJobSeakerId() {
		return JobSeakerId;
	}
	public void setJobSeakerId(String jobSeakerId) {
		JobSeakerId = jobSeakerId;
	}
	public String getJobId() {
		return JobId;
	}
	public void setJobId(String jobId) {
		JobId = jobId;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}
	public Date getApplyDate() {
		return ApplyDate;
	}
	public void setApplyDate(Date applyDate) {
		ApplyDate = applyDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Applicatns() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Applicatns(String jobSeakerId, String jobId, String jobTitle, String jobDescription, Date applyDate,
			String status) {
		super();
		JobSeakerId = jobSeakerId;
		JobId = jobId;
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		ApplyDate = applyDate;
		Status = status;
	}
	

}
