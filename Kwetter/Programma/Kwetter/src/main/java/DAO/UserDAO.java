package DAO;

import Domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joris on 7-3-2017.
 */

@Stateless
public class UserDAO {

    @PersistenceContext
    EntityManager em;

    public void create(User user) {
        em.persist(user);
    }

    public void update(User user) {
        em.merge(user);
    }

    public User get(int id) {
        Query query = em.createNamedQuery("user.getById");
        query.setParameter("userid", id);
        return (User) query.getSingleResult();
    }

    public User get(String name) {
        Query query = em.createNamedQuery("user.getByName");
        query.setParameter("username", name);
        return (User) query.getSingleResult();
    }

    public List<User> getAll(){
            return em.createNamedQuery("user.all").getResultList();
    }
}
