package interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.jsp.jstl.core.Config;

/* Servlet Filter implementation class LoginFilter*/
@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
    String buser;
    
	public LoginFilter() {
        super();
    }
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Filter 1: Login Filter/Interceptor");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String un=request.getParameter("txtname");
		if(buser.equals(un)) {
			out.println("<center>You are blocked for a while on our web"+buser+"</center>");
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig Config) throws ServletException {
		ServletContext ctx = Config.getServletContext();
		buser=ctx.getInitParameter("blockeduser");
	}

}
