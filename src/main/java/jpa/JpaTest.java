package jpa;

import fr.istic.taa.jaxrs.*;
import fr.istic.taa.jaxrs.dao.generic.*;
import fr.istic.taa.jaxrs.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class JpaTest{

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);


		EntityTransaction tx = manager.getTransaction();


		tx.begin();
		try {
			//test.createFiches();



		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		//test.listFiches();



		manager.close();
		System.out.println(".. done");
		EntityManagerHelper.closeEntityManagerFactory();
	}}
