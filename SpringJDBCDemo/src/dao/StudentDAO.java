package dao;

import java.util.Collection;
import university.Student;

public interface StudentDAO {

	public int getStudentCount();
	public Collection<Student> findAllStudents();
	public Student findStudentByID(int studentID);
	public int insertStudent(Student s);
	public int insertStudentReturnId(Student s);
}
