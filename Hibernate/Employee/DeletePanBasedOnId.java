//delete pan based on id
package com.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeletePanBasedOnId {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("select p from Employee p where id = ?1");
		query.setParameter(1, 1);
		List<Employee> employee=query.getResultList();
		for(Employee e:employee)
		{
			entityTransaction.begin();
			entityManager.remove(e.getPan());
			entityTransaction.commit();
		}
	}
}
