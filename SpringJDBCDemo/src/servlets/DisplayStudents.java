package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.StudentDAO;
import university.Student;

/**
 * Servlet implementation class DisplayAllSegments
 */
@SuppressWarnings("serial")
@WebServlet("/displayStudents")
public class DisplayStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayStudents() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		try {
			StudentDAO dao = (StudentDAO) ctx.getBean("studentDAO");
			Collection<Student> students = dao.findAllStudents();

			out.println("<html><body>");
			out.println("<p>Displaying " + students.size() + " segments: ");
			out.println("<table border='1'>");

			for (Student s : students) {
				out.println("<tr>");
				out.println("<td> " + s.getStudentID() + "</td>");
				out.println("<td> " + s.getName() + "</td>");
				out.println("<td> " + s.getGpa() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
		} catch (Exception e) {
			out.println("Display All Students Got exception: " + e.getMessage());
		}

		// with straight JDBC need all commented out below just to get the
		// count,
		// didn't event list the students yet

//		Connection con = null;
//		try {
//			Context context = new InitialContext();
//			DataSource ds = (DataSource) context.lookup("java:comp.env.studntDS");
//			con = ds.getConnection();
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Student");
//			rs.next();
//			out.println("There are " + rs.getInt(1) + " students");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	}

}
