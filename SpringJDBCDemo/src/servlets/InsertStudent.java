package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.StudentDAO;
import university.Student;

/**
 * Servlet implementation class InsertSegment
 */
@WebServlet("/insertSegment")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		String name = request.getParameter("name");
		String sgpa = request.getParameter("gpa");
		double gpa = Double.parseDouble(sgpa);

		try {
			StudentDAO dao = (StudentDAO) ctx.getBean("studentDAO");
			Student student = new Student();
			student.setGpa(gpa);
			student.setName(name);

			int rows = dao.insertStudent(student);
			out.println("<p>Insert successful, " + rows + " inserted!");

		} catch (Exception e) {
			out.println("Insert Student Got exception: " + e);
		}
	}

}
