package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import sysImplementation.Course;
import sysImplementation.Student;

public class Tests {

	@Test
	public void test() {
		Student student = new Student(116911894, "Michael" , "Computer Science");
		student.registerForCourse("CMSC216", 4, "Spring", "2021");
		student.registerForCourse("CMSC132", 4, "Spring", "2021");
		student.setGrades("Spring", "2021", "CMSC216", 'A');
		student.setGrades("Spring", "2021", "CMSC132", 'B');
		student.completeCourses("Spring", "2021");
		
		
		 System.out.println(student.generateTranscript());

		//System.out.println(student.getName());
		//System.out.println(student.getCoursesRegistered());
	 //ArrayList<Course> list =	student.getCoursesCompleted().get("Spring").get("2021");
	// for(int i = 0; i < list.size(); i++) {
	// Course item = list.get(i);
		// System.out.println(item.toString());
	// }


		
	}

}
