package com.revature.hib.examples;

import java.util.List;

public class MainApp {
	  public static void main(String[] args) {
	        StudentDao studentDao = new StudentDao();
	        Student student = new Student("Jasdhir", "Singh", "jas@jas.com");
	        studentDao.saveStudent(student);
	        List < Student > students = studentDao.getStudents();
	        students.forEach(s -> System.out.println(s.getFirstName()));
	    }
}
