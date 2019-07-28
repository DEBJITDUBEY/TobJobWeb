
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

import com.mysql.cj.Session;

/**
 * Servlet implementation class ApplyJobFinal
 */
public class ApplyJobFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJobFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String emailid=null;
		emailid=(String)session.getAttribute("emailid");
		String jobid=request.getParameter("jobid");
		if(emailid!=null) {
			
			String emailid1=(String)session.getAttribute("emailid");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			PreparedStatement smt=con.prepareStatement("insert into ApplyJob (job_id,Job_seaker_id,Apply_date) values(?,?,current_date())");
			smt.setString(1,jobid);
			smt.setString(2, emailid1);
			int rs=smt.executeUpdate();
			if(rs>0) {
				System.out.println("INSERT SUCCESFULLY");
			}
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request,response);
			}
			catch(Exception e) {   System.out.println(e);
			}
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request,response);
		}
		
	}

}
