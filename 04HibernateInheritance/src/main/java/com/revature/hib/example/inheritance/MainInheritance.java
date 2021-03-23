package com.revature.hib.example.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hib.example.utils.HibernateUtil;



public class MainInheritance {
public static void main(String[] args) {
	Transaction transaction = null;
	 Session session = null;
   
       session = HibernateUtil.getSessionFactory().openSession();
       transaction = session.beginTransaction();
       
       CarInsurance cins=new CarInsurance("555","Toyato");
		cins.setClient("AAA");
		cins.setPremium(5000);

		HomeInsurance hins=new HomeInsurance();
		hins.setAddress("Pune");
		hins.setClient("BBB");
		hins.setPremium(2000);
		
		session.save(cins);
		session.save(hins);
		
		transaction.commit();
		
		System.out.println("success");
}
}
