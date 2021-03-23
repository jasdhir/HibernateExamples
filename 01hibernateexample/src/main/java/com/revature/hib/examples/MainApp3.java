package com.revature.hib.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainApp3 {
	private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
	public static void main(String[] args) {
		
	       if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
               
            }
        }
      
    }
	       
	       Session session = sessionFactory.openSession();
	      Transaction  transaction = session.beginTransaction();
	        Student s=new Student("Brain","M","bm@vw.com");
	        session.save(s);
	        transaction.commit();
	        
	        Student s1=session.get(Student.class, 3);
	        System.out.println(s1.getFirstName());
	        session.close();
}
}













