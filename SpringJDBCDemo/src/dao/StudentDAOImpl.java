package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import university.Student;


@Repository("segmentDao")
public class StudentDAOImpl implements StudentDAO {
	Logger log = Logger.getLogger(StudentDAOImpl.class);
	private JdbcTemplate template;
	private StudentRowMapper mapper;
	private DataSource stDS;
	
	public class StudentRowMapper implements RowMapper<Student> {		
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student st = new Student();
			st.setGpa(rs.getDouble("gpa"));
			st.setName(rs.getString("name"));
			st.setStudentID(rs.getInt("studentID"));
		
			return st;
		}
	}
	
	@Autowired
	public void setDataSource(DataSource ds)  {
		template = new JdbcTemplate(ds);
		stDS = ds;
		mapper = new StudentRowMapper();
	}
	
	@Override
	public int getStudentCount() {
		int count = template.queryForObject("SELECT COUNT(*) FROM Student", Integer.class);
		return count;
	}

	@Override
	public Collection<Student> findAllStudents() {
		Collection<Student> students = template.query("SELECT * FROM Student", mapper);
		return students;
	}
	
	@Override
	public Student findStudentByID(int studentID){
		Student s = template.queryForObject("Select * From student where StudentID=?",
											mapper, studentID);
		return s;
	}

	@Override
	public int insertStudent(Student s) {
		
		return template.update(
				"INSERT INTO Student (name, gpa) VALUES(?,?)",
				s.getName(), s.getGpa());
	}
	
	public int insertStudentReturnId(Student s)  {
		
		SimpleJdbcInsert inserter = new SimpleJdbcInsert(stDS);
		inserter.setTableName("Student");
		inserter.usingGeneratedKeyColumns("StudentID");
		Map<String, Object> parms = new HashMap<>();
		parms.put("name", s.getName());
		parms.put("gpa", s.getGpa());
		
		Number id = inserter.executeAndReturnKey(parms);
		return id.intValue();
	}

}
