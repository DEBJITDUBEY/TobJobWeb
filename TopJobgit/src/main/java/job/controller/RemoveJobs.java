package job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.PostedJobDaoImpl;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String jobid= request.getParameter("jobid");
		System.out.println(jobid);
		PostedJobDaoImpl daoImpl=new PostedJobDaoImpl();
		boolean status=daoImpl.removeJobs(jobid);
		System.out.println(status);
		if(status) {
			System.out.println("<h3>You are Successfully remove the Jobs</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("EmployeerHome.jsp");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<h3>You are Succesfully remove the Job.......</h3>");
			
		}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	
	}
}
