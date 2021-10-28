package driverProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList; // import the ArrayList class

import testProject.Student;
import testProject.Module;
import testProject.Course;


public class ProjectTest {
	private ArrayList<Student> students = new ArrayList<Student>();
	@Test
	public void testProject() {
		//Create Arraylist to put students in

		//Create Students
		Student s1 = new Student();
		s1.setName("Sean");
		s1.setAge(21);
		s1.setDOB("12-04-2000");
		
		Student s2 = new Student();
		s2.setName("Aoife");
		s2.setAge(21);
		s2.setDOB("02-06-2000");
		
		Student s3 = new Student();
		s3.setName("Michael");
		s3.setAge(19);
		s3.setDOB("07-09-2002");
		
		Student s4 = new Student();
		s4.setName("Mary");
		s4.setAge(20);
		s4.setDOB("02-03-2001");
		
		//Add students to student list
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		//Create Modules
		Module m1 = new Module();
		m1.setMId("CT4101");
		m1.setMName("Machine Learning");
		
		Module m2 = new Module();
		m2.setMId("CT4104");
		m2.setMName("Advanced Professional Skills");
		
		Module m3 = new Module();
		m3.setMId("CT4126");
		m3.setMName("Information Retrieval");
		
		Module m4 = new Module();
		m4.setMId("CT4146");
		m4.setMName("Graphics and Image Processing");
		
		Module m5 = new Module();
		m5.setMId("CT3101");
		m5.setMName("Programming");
		
		Module m6 = new Module();
		m6.setMId("MA3104");
		m6.setMName("Calculus");
		
		Module m7 = new Module();
		m7.setMId("MA3101");
		m7.setMName("Algebra");
		
		//Create Courses
		Course c1 = new Course();
		c1.setCName("Computer Science & IT");
		
		Course c2 = new Course();
		c2.setCName("Mathematics");
		
		//Assign Students, Classes and Modules
		
		//Modules to Course
		c1.addModule(m1);
		c1.addModule(m2);
		c1.addModule(m3);
		c1.addModule(m4);
		c1.addModule(m5);
		c1.addModule(m6); //Students in CS&IT take this module too
		c2.addModule(m6);
		c2.addModule(m7);
		
		//Students to Course and Courses to Students
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);
		c2.addStudent(s4);
		
		s1.addCourse(c1);
		s2.addCourse(c1);
		s3.addCourse(c1);
		s4.addCourse(c2);
		
		//Students to Module and Modules to Student
		//Students 1 and 2 both do modules 1 and 2
		m1.addStudent(s1);
		s1.addModule(m1);
		m1.addStudent(s2);
		s2.addModule(m1);
		
		m2.addStudent(s1);
		s1.addModule(m2);
		m2.addStudent(s2);
		s2.addModule(m2);
		
		//Student 1 does module 3 and Student 2 does module 4
		m3.addStudent(s1);
		s1.addModule(m3);
		m4.addStudent(s2);
		s2.addModule(m4);
		
		//Student 3 does modules 5 and 6
		m5.addStudent(s3);
		s3.addModule(m5);
		m6.addStudent(s3);
		s3.addModule(m6);
		
		//Student 4 does modules 6 and 7
		m6.addStudent(s4);
		s4.addModule(m6);
		m7.addStudent(s4);
		s4.addModule(m7);
		
		//Print info
		//List of Courses
		System.out.println("List of courses: " + c1.getCName() + ", " + c2.getCName()+"\n");
		//List of Modules in each course
		System.out.println("Modules in " + c1.getCName() + ":");
		for (Module m : c1.getModules()) {
			System.out.print(m.getMName() + ", ");
		}
		System.out.println("\n\nModules in " + c2.getCName() + ":");
		for (Module m : c2.getModules()) {
			System.out.print(m.getMName() + ", ");
		}
		
		System.out.println("\n\nList of students and their details:");
		
		//Print out Student details
		for (Student s : students) {
			System.out.print("Name: " + s.getName() + "\tAge: " + s.getUsername() + "\tModules: ");
			for (Module m : s.getModules()) {
				System.out.print(m.getMName() + ", ");
			}
			System.out.print("\tCourse(s): ");
			for (Course c : s.getCourses()) {
				System.out.print(c.getCName() + ", ");
			}
			System.out.print("\n\n");
		}
	}
}
