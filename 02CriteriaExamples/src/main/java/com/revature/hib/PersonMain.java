package com.revature.hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonMain {
public static void main(String[] args) {
	Transaction transaction= null;
    Session session= HibernateUtil.getSessionFactory().openSession();
    transaction = session.beginTransaction();
    
/*    Person p=new Person();
    p.setName("Justin");
    p.setAge(28);
    
    session.save(p);
    
    transaction.commit();*/
    session.close();
    
    session=HibernateUtil.getSessionFactory().getCurrentSession();
    transaction = session.beginTransaction();
    Person p1=session.load(Person.class, 2);
    p1.setAge(32);
   // session.update(p1);
    session.delete(p1);
    transaction.commit();
}
}
