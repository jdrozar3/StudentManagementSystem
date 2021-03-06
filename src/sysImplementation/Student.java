package sysImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Student {
	private int id, totalCumulativeCredits = 0;
	private String name, major;
	private double gpa = 0;
	private HashMap<String, HashMap<String, ArrayList<Course>>> coursesCompleted;
	private HashMap<String, HashMap<String, ArrayList<Course>>> coursesRegistered;

	public Student(int id, String name, String major) {
		this.id = id;
		this.name = name;
		this.major = major;
		coursesCompleted = new HashMap<String, HashMap<String, ArrayList<Course>>>();
		coursesRegistered = new HashMap<String, HashMap<String, ArrayList<Course>>>();
	}

	public boolean registerForCourse(String name, int credits, String semester, String year) {
		Course newCourse = new Course(name, credits);

		if (this.coursesRegistered.size() == 0) {
			ArrayList<Course> courseList = new ArrayList<Course>();
			courseList.add(newCourse);
			HashMap<String, ArrayList<Course>> temp = new HashMap<String, ArrayList<Course>>();
			temp.put(year, courseList);
			coursesRegistered.put(semester, temp);
		} else {

			ArrayList<Course> registeredList = coursesRegistered.get(semester).get(year);
			if (!registeredList.contains(newCourse)) {
				registeredList.add(newCourse);
			} else {
				return false;
			}

		}

		return true;
	}

	public boolean completeCourses(String semester, String year) {

		if (this.coursesRegistered.containsKey(semester)) {
			ArrayList<Course> temp = this.coursesRegistered.get(semester).get(year);

			if (this.coursesCompleted.containsKey(semester)) {
				this.coursesCompleted.get(semester).put(year, temp);
			} else {
				HashMap<String, ArrayList<Course>> courseMap = new HashMap<String, ArrayList<Course>>();
				courseMap.put(year, temp);
				this.coursesCompleted.put(semester, courseMap);

			}
			this.coursesRegistered.clear();
			return true;
		}

		return false;

	}

	public boolean setGrades(String semester, String year, String courseName, char grade) {

		ArrayList<Course> list = this.coursesRegistered.get(semester).get(year);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(courseName)) {
				list.get(i).setGrade(grade);
				return true;
			}
		}

		return false;
	}

	public String generateTranscript() {
		int numOfCourses = 0;
		String transcript = "";
		transcript += "Name: " + this.getName() + " (" + this.getId() + ")" + "\n";
		transcript += "Major: " + this.getMajor() + "\n\n";

		for (Entry<String, HashMap<String, ArrayList<Course>>> semester : this.getCoursesCompleted().entrySet()) {
			transcript += "***** " + semester.getKey() + " ";
			Map<String, ArrayList<Course>> map = this.getCoursesCompleted().get(semester.getKey());
			for (Entry<String, ArrayList<Course>> year : map.entrySet()) {
				transcript += year.getKey() + " *****\n";
				ArrayList<Course> courseList = map.get(year.getKey());
				numOfCourses += courseList.size();
				for (int i = 0; i < courseList.size(); i++) {
					Course course = courseList.get(i);
					transcript += course.toString() + "\n";
					this.totalCumulativeCredits += course.getCredits();
					if (course.getGrade() == 'A') {
						this.gpa += 4;
					} else if (course.getGrade() == 'B') {
						this.gpa += 3;
					} else if (course.getGrade() == 'C') {
						this.gpa += 2;
					} else if (course.getGrade() == 'D') {
						this.gpa += 1;
					} else {
						// do nothing
					}
				}

			}
			transcript += "\n";

		}
		transcript += "Total Cumulative Credits: " + this.totalCumulativeCredits + "\n";
		transcript += "GPA: " + String.format("%.2f", (this.gpa / numOfCourses)) + "\n";

		return transcript;
	}

	/*****************************************
	 * Getters and Setters
	 *****************************************/

	public int getId() {
		return id;
	}

	public int getTotalCumulativeCredits() {
		return totalCumulativeCredits;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public HashMap<String, HashMap<String, ArrayList<Course>>> getCoursesCompleted() {
		return coursesCompleted;
	}

	public HashMap<String, HashMap<String, ArrayList<Course>>> getCoursesRegistered() {
		return coursesRegistered;
	}

	/*************** PRIVATE METHODS ******************/

}
