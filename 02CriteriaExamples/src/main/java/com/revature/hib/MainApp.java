package com.revature.hib;

import java.util.List;

public class MainApp {
	  public static void main(String[] args) {
	        StudentDao studentDao = new StudentDao();
	      //  Student student = new Student("Jasdhir", "Singh", "Jasdhir@jasdhir.com");
	      //  studentDao.saveStudent(student);
	        List < Student > students = studentDao.getStudents();
	        students.forEach(s -> System.out.println(s.getId()+"  "+s.getFirstName()));
	        
	        Student studentWithId;
	        studentWithId=studentDao.getStudent(1);
	        System.out.println("Student Id : "+studentWithId.getId()+" Student Name : "+studentWithId.getFirstName());
	        
	        
	       // studentDao.updateStudent(1);
	       // studentDao.deleteStudent(3);
	      
	       List < Student > students1 = studentDao.getStudents();
	        students1.forEach(s -> System.out.println(s.getId()+"  "+s.getFirstName()));
	    }
}
