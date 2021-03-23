package com.revature.hib.examples.utils;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.revature.hib.examples.otouni.User;
import com.revature.hib.examples.otouni.UserDetail;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/forHibernate");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "admin");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
               settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
				
				 
				
				
				  // For one to one uni directional
				//  configuration.addAnnotatedClass(com.revature.hib.examples.otouni.User.class);
				//  configuration.addAnnotatedClass(com.revature.hib.examples.otouni.UserDetail.class);
				 
				 
				 
				  
				
				  // For one to one bi directional
				 // configuration.addAnnotatedClass(com.revature.hib.examples.otobi.User.class);
				  //configuration.addAnnotatedClass(com.revature.hib.examples.otobi.UserDetail.class);
				 
                
                
					
					  // For One To Many Uni-directional mapping
					 // configuration.addAnnotatedClass(com.revature.hib.examples.otmu.Employee.class); 
					 // configuration.addAnnotatedClass(com.revature.hib.examples.otmu.Department.class);
					 
                
				
				  // For One To Many Bi-directional mapping
				//  configuration.addAnnotatedClass(com.revature.hib.examples.otmb.Employee.class);
				//  configuration.addAnnotatedClass(com.revature.hib.examples.otmb.Department.class);
				 
				
				  //For Many To Many mapping
				  configuration.addAnnotatedClass(com.revature.hib.examples.mtm.Employee.class);
				  configuration.addAnnotatedClass(com.revature.hib.examples.mtm.Address.class);
				 
                
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}