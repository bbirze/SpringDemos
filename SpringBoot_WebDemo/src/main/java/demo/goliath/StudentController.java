package demo.goliath;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Spring REST getStudents 
//		mixing MVC Model in and 
//		returns the name of a View
//
@Controller
public class StudentController {
	private Logger log = Logger.getLogger(StudentController.class);

	@RequestMapping(value="/studentList", method=RequestMethod.GET)
	public String getStudents(Model model)  {
		log.info("************    Entered");
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student(12, "Sue Smith", 3.44));
		students.add(new Student(87, "Harry Wolfe", 2.68));
		students.add(new Student(947, "Jerry Olde", 3.12));

		log.info("************    adding students: \n\t\t\t" + students);
		
		model.addAttribute("students", students);
		return "studentList";           // view
	}

}
