//Ahmad Amjad Mughal
//121672
//BSCS-6C
//Assignment 2
package com.mughal.Assignment_2;

//Utilities and Dependencies 
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//Session class creates a seesion by getting required database configurations from hibernate.confg.xmal file
public class SessionCreator  
{
	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    //Creating a session and regustering a service
    public static void createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    sessionFactory = configuration.addPackage("com.mughal.Assignment_2").addAnnotatedClass(Person.class).buildSessionFactory(serviceRegistry);

    }

    public static ServiceRegistry getServiceRegistry(){
    	return serviceRegistry;
    }
    
    public static SessionFactory getSessionFactory(){
    	return sessionFactory;
    }
}
