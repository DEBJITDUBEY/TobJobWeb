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

import com.mysql.cj.Session;

import job.dao.JobseakerDaoImpl;
import job.model.Applicatns;

/**
 * Servlet implementation class Apply_Job_Status
 */
public class Apply_Job_Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apply_Job_Status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 try {
		 String emailid= (String) session.getAttribute("emailid");
		 JobseakerDaoImpl jobseakerDaoImpl=new JobseakerDaoImpl();
		 List<Applicatns> alist=jobseakerDaoImpl.ApplyStatus(emailid);
		 for(Applicatns a:alist) {
			 System.out.println(a.getJobSeakerId());
			 System.out.println(a.getJobId());
		 }
		 request.setAttribute("alist",alist);
		 RequestDispatcher rd=request.getRequestDispatcher("Apply_Job_Status.jsp");
		 rd.forward(request, response);
	}
		 catch(Exception e) {
			 System.out.println(e);
		 }
	}

}
