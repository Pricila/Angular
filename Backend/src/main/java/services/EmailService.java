package services;

import models.Email;
import models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by PAVILION-DV6 on 9/4/2017.
 */
@Stateless
public class EmailService {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public List<Email> getEmail(int userid){
        TypedQuery<Email> query = em.createQuery("select e from Email e where e.identification = :id", Email.class);
        query.setParameter("id",userid);
        return query.getResultList();
    }

    public void addEmail(Email email) {
        em.persist(email);
    }
}
