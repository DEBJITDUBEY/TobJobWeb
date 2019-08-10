package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SchemeBuy
 */
public class SchemeBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchemeBuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("scid");
		String email=request.getParameter("email");
		
		try {
			int fee,duration = 0;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			PreparedStatement smt=con.prepareStatement("select * from Scheme where schemeid=?");
			smt.setString(1, sid);
			ResultSet rs=smt.executeQuery();
			if(rs.next()) {
				 fee=Integer.parseInt(rs.getString(5));
				 duration=Integer.parseInt(rs.getString(3));
				
				System.out.println(fee);
				System.out.println(duration);
			}
			
			String sql="update employeer set Scheme_id=?,Scheme_Duration=?,Prchasing_Date=current_date,End_Date=adddate(current_date,interval "+ duration +" day),status_scheme='T' where email=?";
			PreparedStatement smt1=con.prepareStatement(sql);
			smt1.setString(1,sid);
			smt1.setInt(2,duration);
			//smt.setInt(3, duration);
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			Date curdate=new Date();
			
			//smt.setString(1,sdf.format(curdate));
			smt1.setString(3,email);
			int row= smt1.executeUpdate();
			System.out.println(row);
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		} 
		
			
		}
	}


