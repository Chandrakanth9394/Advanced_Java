package com.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class All_of_Employee {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	Query query = entityManager.createQuery("select s from Employee s");
	List<Employee> employees = query.getResultList();
	for(Employee employee : employees)
	{
		System.out.println("The employee id is: "+employee.getId());
		System.out.println("The employee name is: "+employee.getName());
		System.out.println("The employee age is: "+employee.getAge());
		System.out.println("The employee salary is: "+employee.getSal());
		System.out.println("The employee desigantion is: "+employee.getDesignation());
		System.out.println("The employee pan id is:"+employee.getPan());
		Pan pan = employee.getPan();
		System.out.println("The pan id is:"+pan.getId());
		System.out.println("The panno is:"+pan.getPanno());
		System.out.println("The pan address is:"+pan.getAddress());
		System.out.println("-----------------------------");
	}
}
}
