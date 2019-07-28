package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllowJobs
 */
public class AllowJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllowJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String jobid = request.getParameter("jobid");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			
			String sql="update jobs set status1='T' where job_id=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,jobid);
			int row= smt.executeUpdate();
			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("NewJobs.jsp");
			rd.forward(request, response);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}

	
	}


