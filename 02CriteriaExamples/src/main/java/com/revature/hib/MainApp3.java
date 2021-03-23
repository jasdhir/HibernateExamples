package com.revature.hib;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MainApp3 {
public static void main(String[] args) {
	Transaction transactionOne = null;
	  Session sessionOne = HibernateUtil.getSessionFactory().openSession();
	    transactionOne = sessionOne.beginTransaction();
		
		  //String hql = "FROM Student"; 
	   // String hql = "FROM Student S WHERE S.id = 10";
		/*
		 * String hql = "FROM Student S WHERE S.id > 10 ORDER BY S.firstName ASC"; 
		 * Query  query = sessionOne.createQuery(hql); List<Student> results = query.list();
		 * results.forEach(s -> System.out.println(s.getId()+"  "+s.getFirstName()));
		 */
		// Query q2=sessionOne.createSQLQuery("select * from Student");
		  String hql = "FROM Student S WHERE S.id = :student_id";
		  Query query = sessionOne.createQuery(hql);
		  query.setParameter("student_id",1);
		  List<Student> results = query.list();
		  
		  results.forEach(s -> System.out.println(s.getId()+"  "+s.getFirstName()));
		/*
		 * String hql1 = "SELECT S.id,S.firstName FROM Student S"; Query query1 =
		 * sessionOne.createQuery(hql1); List results1 = query1.list(); Iterator it2 =
		 * results1.iterator();
		 * 
		 * while (it2.hasNext()) { Object[] object = (Object[]) it2.next();
		 * System.out.println("Student Id : " + object[0] + " Student Name : " +
		 * object[1]); }
		 */
		  
		/*
		 * Query namedQuery = sessionOne.getNamedQuery("AllStudents");
		 * 
		 * List<Student> namedresults = namedQuery.list(); namedresults.forEach(s ->
		 * System.out.println(s.getId()+"  "+s.getFirstName()));
		 */
		  
		  System.out.println("-----------------------------------");
		 
		/*
		 * Query IdGt10 = sessionOne.getNamedQuery("IdGt10");
		 * 
		 * List<Student> IdGt10results = IdGt10.list(); IdGt10results.forEach(s ->
		 * System.out.println(s.getId()+"  "+s.getFirstName()));
		 */
		  
}
}
