package bizlogic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    public RegistrationServlet() {
        super();
    }
    //works before post and get
    public void init(ServletConfig config) throws ServletException {
    	
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//collecting the form data from incoming request having register.htm
		String name=request.getParameter("txtname");
		int age=Integer.parseInt(request.getParameter("txtage"));
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String username=request.getParameter("txtuname");
		String password=request.getParameter("txtpwd");
//		System.out.println(name+" "+age);
		
	// we will connect backend app server with backend database server
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
