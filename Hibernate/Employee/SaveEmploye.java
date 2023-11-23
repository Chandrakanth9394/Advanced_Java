package com.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveEmploye {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	Employee e1 = new Employee();
	e1.setName("Chandrakanth");
	e1.setAge(23);
	e1.setSal(50000);
	e1.setDesignation("software_developer");
	
	Employee e2 = new Employee();
	e2.setName("Rashid");
	e2.setAge(23);
	e2.setSal(50000);
	e2.setDesignation("software_developer");
	
	Employee e3 = new Employee();
	e3.setName("Abhiram");
	e3.setAge(23);
	e3.setSal(50000);
	e3.setDesignation("software_developer");
	
	Pan p1=new Pan();
	p1.setId(1234);
	p1.setPanno(987456);
	p1.setAddress("ekm");
	
	Pan p2=new Pan();
	p2.setId(1784);
	p2.setPanno(945656);
	p2.setAddress("ekm");
	
	Pan p3=new Pan();
	p3.setId(6544);
	p3.setPanno(569856);
	p3.setAddress("ekm");
	
	e1.setPan(p1);
	e2.setPan(p2);
	e3.setPan(p3);
	
	entityTransaction.begin();
	
	entityManager.persist(e1);
	entityManager.persist(e2);
	entityManager.persist(e3);
	entityManager.persist(p1);
	entityManager.persist(p2);
	entityManager.persist(p3);
	
	entityTransaction.commit();
	
}
}
