package job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import job.dbcon.DbConnection;
import job.model.Employeer;
import job.model.Schemes;




public class EmployeerDaoImpl {
	public   boolean makeEmployerRegistration(Employeer employeer) {
		boolean status=false;
		try {
			Connection con= new DbConnection().getConnection();
			PreparedStatement smt = con.prepareStatement("insert into employeer (email,pwd,mob,Rname,Cname,industryname,designation,employeertype,GSTNO,office_address,city,pin,country,office_number,Government_id,Employee_id_number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			smt.setString(1,employeer.getEmail());
			smt.setString(2,employeer.getPwd());
			smt.setString(3,employeer.getMobile());
			smt.setString(4,employeer.getRegistername());
			smt.setString(5,employeer.getCompanyname());
			smt.setString(6,employeer.getIndustryname());
			smt.setString(7,employeer.getDesignation());
			smt.setString(8,employeer.getType());
			smt.setString(9,employeer.getGSTNO());
			smt.setString(10,employeer.getOfficeAdrress());
			smt.setString(11,employeer.getCity());
			smt.setString(12,employeer.getPin());
			smt.setString(13,employeer.getCountry());
			smt.setString(14,employeer.getOfficenumber());
			smt.setString(15,employeer.getGovid());
			smt.setString(16,employeer.getEmpid());
			
			
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

public String makeUsersLogin(Employeer employer) {
	String status=null;
	try {
		Connection con= new DbConnection().getConnection();
		PreparedStatement smt = con.prepareStatement("select * from employeer where email=? and pwd=?");
		smt.setString(1,employer.getEmail());
		smt.setString(2, employer.getPwd());
		ResultSet result = smt.executeQuery();
		if(result.next())
			status=result.getString(16);
		
		con.close();
		}
	catch(Exception e) {
		System.out.println(e);  
		}
	return status;
}

	public   boolean makeEmployerSchemeRegistration(String emailid, Schemes schemes) {
		boolean status=false;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			String sql="update employeer set Scheme_id=?,Scheme_Duration=?,Prchasing_Date=current_date,End_Date=adddate(current_date,interval "+ schemes.getDuration() +" day),status_scheme='T' where email=?";
			PreparedStatement smt1=con.prepareStatement(sql);
			smt1.setString(1,schemes.getSchemeid());
			smt1.setInt(2,schemes.getDuration());
			//smt.setInt(3, duration);
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			Date curdate=new Date();
			
			//smt.setString(1,sdf.format(curdate));
			smt1.setString(3,emailid);
			int row= smt1.executeUpdate();
			System.out.println(row);
			con.close();
			if(row>0)
				status=true;
			}
		catch(Exception e) {
		    System.out.println("error"+e.getMessage());  
		}
		return status;
	}

	public   boolean checkEmployeerValidity(String emailid) {
		boolean status=false;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			String sql="select * from employeer where email=? and status_scheme='T' and end_date>=current_date()";
			PreparedStatement smt1=con.prepareStatement(sql);
			smt1.setString(1,emailid);
			ResultSet row= smt1.executeQuery();
			if(row.next())
				status=true;
			con.close();
			
			}
		catch(Exception e) {
		    System.out.println("error"+e.getMessage());  
		}
		return status;
	}


}
