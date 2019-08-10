package job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import job.model.Schemes;

public class SchemesDaoImpl {

	public Schemes getSechemeById( String sid) {
		Schemes schemes = null;
	
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			PreparedStatement smt=con.prepareStatement("select * from Scheme where schemeid=?");
			smt.setString(1, sid);
			ResultSet rs=smt.executeQuery();
			if(rs.next()) {
				schemes = new Schemes();
				schemes.setSchemeid(sid);
				schemes.setFee(Integer.parseInt(rs.getString(5)));
				schemes.setDuration(Integer.parseInt(rs.getString(3)));
			}
		}
		catch (Exception e) {
			System.out.println(e);
			
		} 
		return schemes;
			
	}
}
