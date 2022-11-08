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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
	public RegistrationServlet() {
        super();
    }
    //works before post and get
    public void init(ServletConfig config) throws ServletException {
    	
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	//collecting the form data from incoming request having register.htm
		String name=request.getParameter("txtname");
		int age=Integer.parseInt(request.getParameter("txtage"));
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String username=request.getParameter("txtuname");
		String password=request.getParameter("txtpwd");
		System.out.println(name+" "+age+" "+gender);
		
	// we will connect backend app server with backend database server
		
		try {
            // Step 1 : Loading the driver
            Class.forName("oracle.jdbc.OracleDriver");
            //System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
     }

            // Step 2 : Establishing the connectivity
            try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:127.0.0.1:1521:xe","nriems","nriems");
				 String insertquery = "INSERT INTO TBLBANKUSER VALUES (?,?,?,?,?,?,?,?)";
		         pstmt = conn.prepareStatement(insertquery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		        //placing run time text value into wildcards
		         pstmt.setString(1, name);
		         pstmt.setInt(2, age);
		         pstmt.setString(3, gender);
		         pstmt.setString(4, address);
		         pstmt.setString(5, email);
		         pstmt.setString(6, username);
		         pstmt.setString(7, password);
		         //sending the query back to database for insertion to happpen
		         int status=pstmt.executeUpdate();//returns 0 for failure.    
		         
		         if(status>0) {
		        	 out.println("<center><font color=green>Registration Done.</font></center>");
		        	 RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
		        	 redirect.include(request, response);
		         }
		        	 else {
		        		 out.println("<center><font color=red>Something went Wrong</font></center>");
			        	 RequestDispatcher redirect = request.getRequestDispatcher("register.htm");
			        	 redirect.include(request, response);
		        	 }
		         
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("<center><font color=red>Something went Wrong</font></center>");
	        	 RequestDispatcher redirect = request.getRequestDispatcher("register.htm");
	        	 redirect.include(request, response);
			} 
	} 		
	
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
