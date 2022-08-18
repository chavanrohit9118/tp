package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Configuration {
	
	
	public static Session getSession()
	{
		SessionFactory factory=new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		
		return session;
	}

}
