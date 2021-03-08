package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import sysImplementation.Course;
import sysImplementation.Student;

public class Tests {
	
	@Test
	public void test() {
		Student student = new Student(116911894, "Michael", "Computer Science");
		student.registerForCourse("ENES463", 4, "Spring", "2021");
		student.registerForCourse("CMSC132", 4, "Spring", "2021");
		student.setGrades("Spring", "2021", "ENES463", 'B');
		student.setGrades("Spring", "2021", "CMSC132", 'B');
		student.completeCourses("Spring", "2021");

		student.registerForCourse("CMSC330", 3, "Summer", "2021");
		student.registerForCourse("CMSC351", 3, "Summer", "2021");
		student.setGrades("Summer", "2021", "CMSC330", 'A');
		student.setGrades("Summer", "2021", "CMSC351", 'A');
		student.completeCourses("Summer", "2021");

		System.out.println(student.generateTranscript());
	
	}

}
