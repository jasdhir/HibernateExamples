package com.revature.hib.examples;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp2 {
public static void main(String[] args) {
	Transaction transaction = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        Student s=new Student("Rob","Yong","ry@rb.com");
        session.save(s);
        transaction.commit();
        session.close();
}
}
