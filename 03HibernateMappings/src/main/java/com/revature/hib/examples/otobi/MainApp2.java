package com.revature.hib.examples.otobi;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hib.examples.utils.HibernateUtil;



public class MainApp2 {
public static void main(String[] args) {
	 Session session = null;
     Transaction transaction = null;
  
        session = HibernateUtil.getSessionFactory().openSession();
        User u1=session.load(User.class, new Long(1));
        System.out.println(u1);
}
}
