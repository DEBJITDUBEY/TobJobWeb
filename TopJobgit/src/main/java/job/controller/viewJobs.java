package job.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.EmployeerDaoImpl;
import job.model.PostedJob;

/**
 * Servlet implementation class viewJobs
 */
public class viewJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String empid=(String) session.getAttribute("empid");
		EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
		 PostedJob job=new PostedJob();
		 List<PostedJob> jlist=new ArrayList<PostedJob>();
		 jlist=employeerDaoImpl.ViewJobs(empid);
		 for(PostedJob j:jlist){
				System.out.println(j.getJobId());
			}
		 RequestDispatcher rd=request.getRequestDispatcher("EmployeerViewJobs.jsp");
		 request.setAttribute("jlist", jlist);
			rd.include(request, response);
		 
	}

}
