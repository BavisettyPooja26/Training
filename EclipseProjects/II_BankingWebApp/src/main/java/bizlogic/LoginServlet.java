package bizlogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {
    	
    }
    //MIME: Multipurpose Internet Mail Extension - type of data to be exchanged between browser and server
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//collecting the form data from incoming request having register.htm
		String username=request.getParameter("txtuname");
		String password=request.getParameter("txtpwd");
		System.out.println(username+" "+password);
		//login validation at server
		if(username.equals("pooja")&&password.equals("poo")) {
			//out.println("<center><font color=green size=4>login successful</font></center>");//displayed back to browser as response
			//REDIRECTION:
			RequestDispatcher redirect = request.getRequestDispatcher("service.htm");
			redirect.forward(request, response);
		}else {
			out.println("<center><font color=red size=4>login unsuccessful</font></center> ");
//			RequestDispatcher redirect = request.getRequestDispatcher("login.htm");
//			redirect.include(request, response);
			//sercer to browser communication
			response.sendRedirect("http://google.com");
		}
		
	// we will connect backend app server with backend database server
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
