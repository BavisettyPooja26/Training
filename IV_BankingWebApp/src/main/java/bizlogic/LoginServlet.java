package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    String drivername, dblocation, dbusername, dbpassword,site_country; 
    
    public LoginServlet() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {
    	ServletContext ctx = config.getServletContext();
    	drivername=ctx.getInitParameter("dblodbdrivercation");
    	drivername=ctx.getInitParameter("dbconnection");
    	drivername=ctx.getInitParameter("dbuser");
    	drivername=ctx.getInitParameter("dbpass");
    	
    	site_country=config.getInitParameter("loginitparam");
    }
    //MIME: Multipurpose Internet Mail Extension - type of data to be exchanged between browser and server
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		//collecting the form data from incoming request having register.htm
		String username=request.getParameter("txtuname");
		String password=request.getParameter("txtpwd");
		System.out.println(username+" "+password);
		
		//login validation at server
		if(true) {
			try {
	            // Step 1 : Loading the driver
	            Class.forName(drivername);
	            //System.out.println("Driver Loaded");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException(e);
	     }

	            // Step 2 : Establishing the connectivity
	            try {
					conn = DriverManager.getConnection(dblocation,dbusername,dbpassword);
					 String searchquery="select cusername,cuserpwd from tblbankuser where ucusername=? and cuserpwd=?";
					 pstmt = conn.prepareStatement(searchquery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					 pstmt.setString(1, username);
					 pstmt.setString(2, password);
					 rs=pstmt.executeQuery();
					 
					    if(rs.next()) {
//					    	out.println("<center><font color=green size=4>login successful</font></center> ");
		    			
					    	//session management
					    	//content of one servlet available to another servlet(info sharing during run time)
					    	//Session is the ti me gap between login and logout
					    	HttpSession sessionid=request.getSession();
					    	System.out.print("id:"+sessionid);
					    	//storing user specific value in session
					    	sessionid.setAttribute("unkey",username);
					    	sessionid.setAttribute("unpwd",password);
					    	
					    	RequestDispatcher redirect = request.getRequestDispatcher("profileserv");
			    			redirect.forward(request, response);
			            }
			            else {
			    			out.println("<center><font color=red size=4>login unsuccessful</font></center> ");
			    			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
			    			redirect.include(request, response);
			    			//sercer to browser communication
			    			//response.sendRedirect("http://google.com");
			    		}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("<center><font color=red size=4>login unsuccessful</font></center> ");
	    			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
	    			redirect.include(request, response);      
				}        
		}
		
	// we will connect backend app server with backend database server
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
