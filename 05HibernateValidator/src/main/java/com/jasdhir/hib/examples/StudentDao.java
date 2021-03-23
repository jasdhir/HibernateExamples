package com.jasdhir.hib.examples;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {
	 
    public void saveStudent(Student student) {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List < Student > getStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
  
    }
    
    public Student getStudent(int id) {
    	Student student;
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	  transaction = session.beginTransaction();
        	
           //Return the persistent instance of the given entity class with the given identifier,  or null if there is no such persistent instance. 
        	//student= session.get(Student.class, id);
        	
        	  //If no row found , it will throws an ObjectNotFoundException.
        	student= session.load(Student.class, new Integer(id));
        	System.out.println(student.getFirstName());
        	transaction.commit();
        }
        return student;
    }
    
    public void updateStudent(int id) {
    	Student student;
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      	  transaction = session.beginTransaction();
      	student= session.get(Student.class, new Integer(id));
      	student.setFirstName("Rajive");
      	session.update(student);
      	transaction.commit();
      	
        }
    	
    }
    public void deleteStudent(int id) {
    	Student student;
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      	  transaction = session.beginTransaction();
      	student= session.get(Student.class, new Integer(id));
      	
      	session.delete(student);
      	transaction.commit();
      	
        }
    	
    }
    
   
    

}