package Listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

public class RequestResponseListener implements ServletRequestListener {

    public RequestResponseListener() {
      
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
       System.out.println("Response got off the server");
    }
    public void requestInitialized(ServletRequestEvent sre)  { 
	System.out.println("Request received at the server");
    }
}
