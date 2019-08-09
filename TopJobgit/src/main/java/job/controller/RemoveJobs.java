package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveJobs
 */
public class RemoveJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobid= request.getParameter("jobid");
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			String sql="Delete from jobs where job_id=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,jobid);
			int row= smt.executeUpdate();
			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("EmployeerViewJobs.jsp");
			rd.forward(request, response);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}

	
	}
