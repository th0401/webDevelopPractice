package day14;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class PracListener
 *
 */
@WebListener
public class PracListener implements ServletContextListener {
	
    /**
     * Default constructor. 
     */
    public PracListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 ServletContext context=sce.getServletContext();
    	 ArrayList<Coffee> datas = new ArrayList<Coffee>();
    	 datas.add(new Coffee("�Ƹ޸�ī��"));
    	 datas.add(new Coffee("ī���"));
    	 datas.add(new Coffee("����������"));
    	 context.setAttribute("datas", datas);
         
    }
	
}
