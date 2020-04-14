package com.ahmad.Lab_07;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class SessionCreator{
	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    public static void createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    sessionFactory = configuration.addPackage("com.ahmad.Lab_07").addAnnotatedClass(Person.class).buildSessionFactory(serviceRegistry);

    }

    public static ServiceRegistry getServiceRegistry(){
    	return serviceRegistry;
    }
    
    public static SessionFactory getSessionFactory(){
    	return sessionFactory;
    }

}

