package job.model;

public class PostedJob {
	private String jobId;
	private String employeeId;
	private String jobTitle;
	private String cname;
	private String cwebsite;
	private String jdescription;
	private String skills;
	private String experience; 
	private String salary;
	private String Jlocation;
	private String Status;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCwebsite() {
		return cwebsite;
	}
	public void setCwebsite(String cwebsite) {
		this.cwebsite = cwebsite;
	}
	public String getJdescription() {
		return jdescription;
	}
	public void setJdescription(String jdescription) {
		this.jdescription = jdescription;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getJlocation() {
		return Jlocation;
	}
	public void setJlocation(String jlocation) {
		Jlocation = jlocation;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public PostedJob(String jobId, String employeeId, String jobTitle, String cname, String cwebsite,
			String jdescription, String skills, String experience, String salary, String jlocation, String status) {
		super();
		this.jobId = jobId;
		this.employeeId = employeeId;
		this.jobTitle = jobTitle;
		this.cname = cname;
		this.cwebsite = cwebsite;
		this.jdescription = jdescription;
		this.skills = skills;
		this.experience = experience;
		this.salary = salary;
		this.Jlocation = jlocation;
		this.Status = status;
	}
	public PostedJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
