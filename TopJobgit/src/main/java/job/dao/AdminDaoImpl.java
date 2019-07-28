package job.dao;
import job.dbcon.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import job.model.Admin;


public class AdminDaoImpl {
	public boolean makeAdminLogin(Admin admin) {
		boolean status=false;
		try {
			Connection con= new DbConnection().getConnection();
			PreparedStatement smt = con.prepareStatement("select * from Admin1 where Id=? and pwd=?");
			smt.setString(1,admin.getId());
			smt.setString(2, admin.getPassword());
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
