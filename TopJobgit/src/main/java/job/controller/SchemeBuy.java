package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			PreparedStatement smt=con.prepareStatement("select fee,Duration from Scheme where schemeid=sid");
			ResultSet rs=smt.executeQuery();
			while(rs.next()) {
				int fee=Integer.parseInt(rs.getString(5));
				int duration=Integer.parseInt(rs.getString(3));
				
				System.out.println(fee);
				System.out.println(duration);
			}
		} catch (Exception e) {
			
		} 
		
			
		}
	}


