package job.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

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
}