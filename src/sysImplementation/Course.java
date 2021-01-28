package sysImplementation;

public class Course {
	String name;
	char grade;
	int credits;
	
	public Course(String name, int credits) {
		this.name = name;
		this.credits = credits;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}


	public int getCredits() {
		return credits;
	}


	public char getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return  name + " Credits: " + credits
				+ " Final Grade: " + grade ;
	}
	
	

}
