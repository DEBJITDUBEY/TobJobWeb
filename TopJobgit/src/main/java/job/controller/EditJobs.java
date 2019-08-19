package job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import job.model.PostedJob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.PostedJobDaoImpl;
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
			PostedJob job= new PostedJob();
			job.setJobId(jobId);
			job.setJobTitle(jobTitle);
			job.setCname(cname);
			job.setCwebsite(cwebsite);
			job.setExperience(experience);
			job.setJdescription(jdescription);
			job.setJlocation(jlocation);
			job.setSkills(skills);
			job.setSalary(salary);
			job.setStatus(status1);
			
			PostedJobDaoImpl daoImpl=new PostedJobDaoImpl();
			boolean status=daoImpl.editJobsUpdate(job);
			if(status) {
				RequestDispatcher rd=request.getRequestDispatcher("EmployeerHome.jsp");
				PrintWriter out = response.getWriter();
				rd.include(request, response);
				out.println("<h3>You are Succesfully Edit the Job.......</h3>");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}}

		
		
		
		
		