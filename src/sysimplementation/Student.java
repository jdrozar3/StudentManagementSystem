package sysimplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
	private int id, totalCumulativeCredits;
	private String name, major;
	private double gpa;
	private HashMap<String, HashMap<String, ArrayList<Course>>> coursesCompleted;
	private HashMap<String, HashMap<String, ArrayList<Course>>> coursesRegistered;

	public Student(int id, String name, String major) {
		this.id = id;
		this.name = name;
		this.major = major;
		coursesCompleted = new HashMap<String, HashMap<String, ArrayList<Course>>>();
		coursesRegistered = new HashMap<String, HashMap<String, ArrayList<Course>>>();
	}

	public boolean registerForCourse(String name, int credits, String semester,
			String year) {
		Course newCourse = new Course(name, credits);

		if (this.coursesRegistered.size() == 0) {
			ArrayList<Course> courseList = new ArrayList<Course>();
			courseList.add(newCourse);
			HashMap<String, ArrayList<Course>> temp = new HashMap<String, ArrayList<Course>>();
			temp.put(year, courseList);
			coursesRegistered.put(semester, temp);
		} else {

			ArrayList<Course> registeredList = coursesRegistered.get(semester)
					.get(year);
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
			ArrayList<Course> temp = this.coursesRegistered.get(semester)
					.get(year);

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

	public boolean setGrades(String semester, String year, String courseName,
			char grade) {

		ArrayList<Course> list = this.coursesRegistered.get(semester).get(year);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(courseName)) {
				list.get(i).setGrade(grade);
				return true;
			}
		}

		return false;
	}

	public void generateTranscript() {

	}

	/***************************
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
	private void updateCumulativeGpa() {

	}

	private void updateTotalCredits() {

	}

}
