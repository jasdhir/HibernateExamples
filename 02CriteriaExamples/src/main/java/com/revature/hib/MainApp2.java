package com.revature.hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp2 {
public static void main(String[] args) {
	Transaction transactionOne = null;
    Transaction transactionTwo = null;
    Session sessionOne = HibernateUtil.getSessionFactory().openSession();
    transactionOne = sessionOne.beginTransaction();

    // create student object
    Student student = new Student("Jasdhir443", "Singh", "jj@kk.com");

    // save student object
    sessionOne.save(student);

    // commit transaction
    transactionOne.commit();

    // close first session 
    sessionOne.close();
		
		  // open     sessionTwo 
    Session sessionTwo =  HibernateUtil.getSessionFactory().openSession();
		  
		  transactionTwo = sessionTwo.beginTransaction();
		  
		  // change detached student object name 
		  student.setFirstName("Jasd555");
		  
		  // merge method is to update a persistent entity instance with new field   values // from a detached entity instance.  
		  sessionTwo.merge(student);
		  transactionTwo.commit();
		  
		  sessionTwo.close();
		 }
}
