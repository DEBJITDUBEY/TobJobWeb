package job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import job.dbcon.DbConnection;
import job.model.Employeer;
import job.model.Jobseaker;

public class JobseakerDaoImpl {

	
	public   boolean makeJobseakerRegistration(Jobseaker jobseaker) {
		boolean status=false;
		try {
			Connection con= new DbConnection().getConnection();
			PreparedStatement smt = con.prepareStatement("insert into jobseaker values (?,?,?,?,?"
					+ ",?,?,?,?,?"
					+ ",?,?,?,?,?"
					+ ",?,?,?,?,?"
					+ ",?,?,?,?,?"
					+ ",?,?,?)");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			smt.setString(1,jobseaker.getName());
			smt.setString(2,jobseaker.getEmail());
			smt.setString(3,jobseaker.getPassword());
			smt.setString(4,sdf.format(jobseaker.getDate_of_birth()));
			smt.setString(5,jobseaker.getGender());
			smt.setString(6,jobseaker.getMobile_no());
			
			smt.setString(7,jobseaker.getGov_proof_id());
			smt.setString(8,jobseaker.getId_details());
			smt.setString(9,jobseaker.getCity());
			smt.setString(10,jobseaker.getState());
			
			
			smt.setString(11,jobseaker.getZip());
			smt.setString(12,jobseaker.getCountry());
			smt.setString(13,jobseaker.getClass_x_y_board());
			smt.setString(14,jobseaker.getClass_x_year());
			smt.setString(15,jobseaker.getClass_x_marks());
			
			smt.setString(16,jobseaker.getClass_xii_board());
			smt.setString(17,jobseaker.getClass_xii_year());
			smt.setString(18,jobseaker.getClass_xii_mark());
			
			smt.setString(19,jobseaker.getGraduate_uni());
			smt.setString(20,jobseaker.getGraduate_colname());
			smt.setString(21,jobseaker.getGraduate_year());
			smt.setString(22,jobseaker.getGraduate_mark());
			
			smt.setString(23,jobseaker.getGraduate_branch());
			smt.setString(24,jobseaker.getOther_board());
			smt.setString(25,jobseaker.getOther_name());
			smt.setString(26,jobseaker.getOther_year());
			
			smt.setString(27,jobseaker.getOther_marks());
			smt.setString(28,jobseaker.getOther_salary());
			
			
			
			
			int result = smt.executeUpdate();
			
			System.out.println("Result:"+result);
			con.close();
			if(result>0)
				status=true;
			}
					catch(Exception e) {
						System.out.println("er1:"+e);  
					}
		return status;
	}
	
	
	public boolean makeUsersLogin(Jobseaker jobseaker) {
		boolean status=false;
		try {
			Connection con= new DbConnection().getConnection();
			PreparedStatement smt = con.prepareStatement("select * from Jobseaker where email=? and password=?");
			smt.setString(1,jobseaker.getEmail());
			smt.setString(2, jobseaker.getPassword());
			ResultSet result = smt.executeQuery();
			if(result.next())
				status=true;
			
			con.close();
			}
		catch(Exception e) {
			System.out.println(e);  
			}
		return status;
	}

}