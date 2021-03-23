package com.jasdhir.hib.examples;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class MainApp {
	  public static void main(String[] args) {
	        StudentDao studentDao = new StudentDao();
	        Validator validator = Validation
                    .buildDefaultValidatorFactory()
                    .getValidator();

	      
	        Student student = new Student("BBBBBBBBBBB", "Singh", "Jasdhir@jasdhir.com");
	        
	        Set<ConstraintViolation<Student>> constraintViolations =
	        	       validator.validate(student);

	        	for (ConstraintViolation<?> violation: constraintViolations) {
	        	   System.out.format("%10s | %30s | is %10s%n",
	        	           violation.getPropertyPath(),
	        	           violation.getMessage(),
	        	           violation.getInvalidValue()
	        	           );
	        	}
	      studentDao.saveStudent(student);
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
