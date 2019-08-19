package job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.PostedJobDaoImpl;
import job.model.PostedJob;

/**
 * Servlet implementation class EditJobs1
 */
public class EditJobs1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditJobs1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobid= request.getParameter("jobid");
		PostedJobDaoImpl daoImpl=new PostedJobDaoImpl();
		 PostedJob job=daoImpl.editJobs1(jobid);
		 RequestDispatcher rd=request.getRequestDispatcher("EditJobs.jsp");
		 request.setAttribute("job", job);
		 rd.include(request, response);
		 
	}

}
