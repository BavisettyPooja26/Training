package bizlogic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Feedback;

public class feedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public feedbackServlet() {
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	
    	String fid = request.getParameter("txtfeedid");
    	String fname = request.getParameter("txtfeedname");
    	String fmsg = request.getParameter("txtfeedmsg");
    	
    	Feedback feedobj = new Feedback();
    	feedobj.setFeedid(Integer.parseInt(fid));
    	feedobj.setFeedid(Integer.parseInt(fname));
    	feedobj.setFeedid(Integer.parseInt(fmsg));
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
