package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	
	Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    String drivername, dblocation, dbusername, dbpassword; 
    
    public ProfileServlet() {
        super();
    }
 public void init(ServletConfig config) throws ServletException {
 	ServletContext ctx = config.getServletContext();
 	drivername=ctx.getInitParameter("dblodbdrivercation");
 	drivername=ctx.getInitParameter("dbconnection");
 	drivername=ctx.getInitParameter("dbuser");
 	drivername=ctx.getInitParameter("dbpass");
 }
 public ServletConfig getServletConfig() {
	 return null;
 }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession sid=request.getSession(false);//only object; no token
		if(sid!=null) {
			//retrieving value passed by login servlet
			
			String user=(String) sid.getAttribute("unkey");
			String pwd=(String) sid.getAttribute("unpwd");
			out.println("<center><font color=green>Welcome, "+user+"</font></center>");
			out.println("<a href=logout.htm>Logout</a>");
		}
		else {
			out.println("<center><font color=red>Protected Resource...Session Id required</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			redirect.include(request, response);
		}
		//use jdbc code to build the project page
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
