package execution;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Car;
import model.Person;
import util.Configuration;

public class App {

	public static void main(String[] args) {
		
		Person p1 =new Person();
		p1.setPname("ABC");
		p1.setCity("Pune");
		
		Person p2 =new Person();
		p2.setPname("EFG");
		p2.setCity("Delhi");
		
		Person p3 =new Person();
		p3.setPname("XYZ");
		p3.setCity("Mumbai");
		
		Car c1 =new Car();
		c1.setCName("Wagon R");
		c1.setPrice(500000);
		
		
		Car c2 =new Car();
		c2.setCName("Swift");
		c2.setPrice(1000000);
		
		
		Car c3 =new Car();
		c3.setCName("Creta");
		c3.setPrice(1500000);

		c1.setPerson(p1);
		c2.setPerson(p2);
		c3.setPerson(p3);
		System.out.println("*****Car has set to Person*****");
		
		p1.setCar(c1);
		p1.setCar(c2);
		p1.setCar(c3);
		System.out.println("*****Person has set to Car*****");
		
		

		Session session = Configuration.getSession();
		System.out.println("*****Session Begin*****");
		
		Transaction tx = session.beginTransaction();
		System.out.println("*****Transaction Begin*****");
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		System.out.println("*****Person Session saved*****");
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		System.out.println("*****Car session saved*****");
		
		tx.commit();
		System.out.println("*****Transaction commit*****");
		
		session.close();
		System.out.println("Done");
		

		
	}

}
