package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import acct.AccountManager;

@WebServlet("/TestTransactions")
public class TestTransactions extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		try {
			AccountManager mgr = (AccountManager)ctx.getBean("accountMgr");
			
			out.println("Before transfer: <br>");
			out.println(mgr.getAccountInfo(1) + "<br>");
			out.println(mgr.getAccountInfo(1) + "<br>");	
			
			mgr.transfer(1, 2, 1);

			out.println("After transfer: <br>");
			out.println(mgr.getAccountInfo(1) + "<br>");
			out.println(mgr.getAccountInfo(1) + "<br>");	

		} catch(Exception e)  {
			out.println("Something went wrong, exception: " + e);		
		}
	}
	

}
