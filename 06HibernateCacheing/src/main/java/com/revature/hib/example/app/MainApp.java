package com.revature.hib.example.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hib.example.utils.HibernateUtil;
import com.revature.hib.example.entity.Person;


public class MainApp {
	public static void main(String[] args) {
	      Session session = null;
	      Transaction transaction = null;
	      try {
	        
	         //Retrieve the person object from database
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	        
	         Person person=session.get(Person.class, new Long(1));
	         System.out.println(person);
	         transaction.commit();
	         session.close();
	         
	         //Retrieve the person object from database
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	        
	         Person person2=session.get(Person.class, new Long(2));
	         System.out.println(person2);
	         transaction.commit();
	         session.close();
	         
	         //Retrieve the person object from cache
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	       
	         Person person3=session.get(Person.class,new Long(1));
	         System.out.println(person3);
	         transaction.commit();
	         session.close();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	     
	   }
}
