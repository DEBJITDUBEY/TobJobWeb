package job.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.EmployeerDaoImpl;

public class EmployeerFilter  implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpServletRequest hrequest = (HttpServletRequest)request;
		
		String uri= hrequest.getRequestURI();
		HttpSession session = hrequest.getSession(false);
		
		String emailid =null;
		if(session!=null)
			emailid = (String)session.getAttribute("emailid");
		System.out.println("Email id for filter :"+emailid);
		
		if(uri.endsWith(".html") || uri.endsWith("Login")) { 
			chain.doFilter(request, response); }
		else
		 if(emailid==null || session==null ) {
		 		hresponse.sendRedirect("EmployeerLogin.jsp"); }
		 	else {
		 			if( new EmployeerDaoImpl().checkEmployeerValidity(emailid))
		                chain.doFilter(request, response); 
		 			else{
		 				RequestDispatcher rd = request.getRequestDispatcher("scheme.jsp");
		 				rd.forward(hrequest, hresponse); }
			}
		}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
