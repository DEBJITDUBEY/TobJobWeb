package job.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.PostedJobDaoImpl;
import job.model.PostedJob;

/**
 * Servlet implementation class JobPost
 */
public class JobPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobId="J"+(int)(Math.random()*100)+(int)(Math.random()*100)+(int)(Math.random()*100);
		String jobTitle=request.getParameter("jtitle");
		String cname=request.getParameter("cname");
		String cwebsite=request.getParameter("jweb");
		String jdescription=request.getParameter("jdescription");
		String skills=request.getParameter("jskill");
		String experience=request.getParameter("jexperience");
		String salary=request.getParameter("jsalary");
		String jlocation=request.getParameter("jlocation");
		String status1="F";
		HttpSession session =request.getSession();
		String employeeId=(String)session.getAttribute("empid");
		
		PostedJob postedJob = new PostedJob(jobId, employeeId, jobTitle, cname, cwebsite, jdescription, skills, experience, salary, jlocation,status1);
		PostedJobDaoImpl postedJobDaoImpl = new PostedJobDaoImpl();
		boolean status= postedJobDaoImpl.makeJobPost(postedJob);
		
		
		if(status)
		System.out.println("good");
		else
			System.out.println("bad");
	}

}
