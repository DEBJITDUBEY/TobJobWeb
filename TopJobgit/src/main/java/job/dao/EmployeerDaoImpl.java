package job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import job.dbcon.DbConnection;
import job.model.Employeer;




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
}

