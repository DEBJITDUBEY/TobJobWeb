package job.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import job.dbcon.DbConnection;
import job.model.PostedJob;

public class PostedJobDaoImpl {
	
	public   boolean makeJobPost(PostedJob jobPost) {
		boolean status=false;
		try {
			Connection con= new DbConnection().getConnection();
			PreparedStatement smt = con.prepareStatement("insert into Jobs values (?,?,?,?,?"
					+ ",?,?,?,?,?,?)");
		
			smt.setString(1,jobPost.getJobId());
			smt.setString(2,jobPost.getEmployeeId());
			smt.setString(3,jobPost.getJobTitle());
			smt.setString(4,jobPost.getCname());
			smt.setString(5,jobPost.getCwebsite());
			smt.setString(6,jobPost.getJdescription());
			smt.setString(7,jobPost.getSkills());
			smt.setString(8,jobPost.getExperience());
			smt.setString(9,jobPost.getSalary());
			smt.setString(10,jobPost.getJlocation());
			smt.setString(11,jobPost.getStatus());
		
		int result = smt.executeUpdate();
		
		System.out.println("Result:"+result);
		con.close();
		if(result>0)
			status=true;
		}
				catch(Exception e) {
					System.out.println("error"+e.getMessage());  
				}
		return status;

}
	public boolean removeJobs(String jobId) {
		boolean Status=false;
	System.out.println(jobId);
		try {
			Connection con=new DbConnection().getConnection();
			String sql="Delete from jobs where job_id=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,jobId);
			int row= smt.executeUpdate();
			if(row>0) {
				Status=true;
			}
					
		}catch(Exception e) {
				System.out.println(e);
			}
		return Status;
	}
	
	
	public boolean editJobsUpdate(PostedJob job) {
		boolean status=false;
		try {
			Connection con=new DbConnection().getConnection();
			String sql="update jobs set Job_title=?,Company_name=? ,Company_website=?, Job_descriptions=?, skills=?, Experience=? ,salary=? ,Job_Location=? ,Status1=? where job_id=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,job.getJobTitle());
			smt.setString(2,job.getCname());
			smt.setString(3,job.getCwebsite());
			smt.setString(4,job.getJdescription());
			smt.setString(5,job.getSkills());
			smt.setString(6,job.getExperience());
			smt.setString(7,job.getSalary());
			smt.setString(8,job.getJlocation());
			smt.setString(9,job.getStatus());
			smt.setString(10,job.getJobId());
			int row= smt.executeUpdate();
			if(row>0) {
				status=true;
			}
		}
			catch(Exception e) {
				System.out.println(e);
		}
		return status;
		
		
		
	}
	
	public PostedJob editJobs1(String Jobid) {
		 PostedJob job=new PostedJob();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			 PreparedStatement smt=con.prepareStatement("select * from jobs where Job_id=?");
			 smt.setString(1,Jobid);
			 ResultSet rs=smt.executeQuery();
			 if(rs.next()) {
				
				 job.setJobId(rs.getString(1));
				 job.setCname(rs.getString(4));
				 job.setCwebsite(rs.getString(5));
				 job.setEmployeeId(rs.getString(2));
				 job.setExperience(rs.getString(8));
				 job.setJdescription(rs.getString(6));
				 job.setJlocation(rs.getString(10));
				 job.setJobTitle(rs.getString(3));
				 job.setSalary(rs.getString(9));
				 job.setSkills(rs.getString(7));
				 job.setStatus(rs.getString(11));
				 
			 }
			 }
			 catch(Exception e) {
				 System.out.println(e);
			 }
		
		
		
		return job;
		
	}
	
	
	
	
}