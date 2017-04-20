package services;

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
public class UserService {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public List<User> getUser(int userid){
        TypedQuery<User> query = em.createQuery("select u from User u where u.identification = :id", User.class);
        query.setParameter("id", userid);
        return query.getResultList();
    }

    public List<User> getAll(){
        TypedQuery<User> query = em.createQuery("select u from User u ", User.class);
        return query.getResultList();
    }

    public void addUser(User user){
        List<User> list = getAll();
        String result = "User saved!!!";
        if (list.contains(user)) {
            result = "User exists!!!";
        }else {
            em.persist(user);
        }
    }
}
