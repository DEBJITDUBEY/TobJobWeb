package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dbcon.DbConnection;

/**
 * Servlet implementation class EditJobs
 */
public class EditJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			String jobId=request.getParameter("jobid");
			System.out.println(jobId);
			String jobTitle=request.getParameter("Jobtitle");
			System.out.println(jobTitle);
			String cname=request.getParameter("cname");
			String cwebsite=request.getParameter("cwebsite");
			String jdescription=request.getParameter("jdescription");
			String skills=request.getParameter("jskilss");
			String experience=request.getParameter("jexperience");
			String salary=request.getParameter("jsalary");
			String jlocation=request.getParameter("jlocation");
			String status1="F";
			
			Connection con=new DbConnection().getConnection();
			String sql="update jobs set Job_title=?,Company_name=? ,Company_website=?, Job_descriptions=?, skills=?, Experience=? ,salary=? ,Job_Location=? ,Status1=? where job_id=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,jobTitle);
			smt.setString(2,cname);
			smt.setString(3,cwebsite);
			smt.setString(4,jdescription);
			smt.setString(5,skills);
			smt.setString(6,experience);
			smt.setString(7,salary);
			smt.setString(8,jlocation);
			smt.setString(9,status1);
			smt.setString(10,jobId);
			int row= smt.executeUpdate();
			System.out.println(row);
			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("EmployeerViewJobs.jsp");
			rd.forward(request, response);
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}}

		
		
		
		
		