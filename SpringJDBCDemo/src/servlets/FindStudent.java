package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.StudentDAO;
import university.Student;

/**
 * Servlet implementation class DisplaySegmentCount
 */
@WebServlet("/findStudent")
public class FindStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			StudentDAO dao = (StudentDAO)ctx.getBean("studentDAO");
			Student s = dao.findStudentByID(studentID);
			if (s != null) {
				out.println("<p>Student ID: " + s.getStudentID() + "</p>");
				out.println("<p>Name: " + s.getName() + "</p>");
				out.println("<p>GPA: " + s.getGpa() + "</p>");
				}
		} catch (NumberFormatException e) {
			out.println("Invalid Number Entered!  Press 'Back' and try again.");
			e.printStackTrace();
		} catch (EmptyResultDataAccessException e) {
			out.println("Student not found");
			e.printStackTrace();
		}

	}

}
