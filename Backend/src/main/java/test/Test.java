package test;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by PAVILION-DV6 on 19/4/2017.
 */
public class Test {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        User employee = new User();
        employee.setAddress("direccion");
        employee.setFirst_name("Prasad");
        employee.setLast_name("kharkar");

        txn.begin();
        em.persist(employee);
        txn.commit();

    }
}
