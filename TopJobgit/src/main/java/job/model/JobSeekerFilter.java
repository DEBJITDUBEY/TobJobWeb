package job.model;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class JobSeekerFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
        System.out.println("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        System.out.println("session:"+session);
        if (session == null) {   //checking whether the session exists
            this.context.log("Unauthorized access request");
            res.sendRedirect(req.getContextPath() + "/index.jsp");
        }
        else {
           String emailid = (String)session.getAttribute("emailid");
           String role = (String)session.getAttribute("role");
           
           System.out.println("emailid:"+emailid);
           if(emailid!=null && role!=null && role.equals("jobseeker")==true)
        	   // pass the request along the filter chain
               chain.doFilter(request, response);
           else
        	   res.sendRedirect(req.getContextPath() + "/index.jsp");
           
        }
    }

    public void destroy() {
        //close any resources here
    }
}


