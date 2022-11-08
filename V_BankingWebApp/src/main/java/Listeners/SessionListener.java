package Listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
   
    }

    public void sessionCreated(HttpSessionEvent se)  { 
         //any custom logic u want to implement after the time of session creation
    	System.out.println("Session started");
    }
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//any custom logic u want to implement after the time of session destruction
    	System.out.println("Session destroyed");
    }
	
}
