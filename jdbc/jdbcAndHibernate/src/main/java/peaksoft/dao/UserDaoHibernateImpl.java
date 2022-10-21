package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private  EntityManager entityManager = Util.creatEntityManager();
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("create table users(id serial primary key not null ," +
                "name varchar(50) not null ," +
                "lastName varchar(50) not null ," +
                "age smallint) ").executeUpdate();
       entityManager.getTransaction().commit();

    }

    @Override
    public void dropUsersTable() {
      entityManager.getTransaction().begin();
      entityManager.createNativeQuery("drop table if exists users").executeUpdate();
      entityManager.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
            entityManager.getTransaction().begin();
            entityManager.persist(new User(name,lastName,age));
            entityManager.getTransaction().commit();

    }

    @Override
    public void removeUserById(long id) {
        try {
            entityManager.getTransaction().begin();
             entityManager.createQuery("delete from User u where u.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        }catch (EntityNotFoundException e) {
            System.out.println("Can't find User for ID " + id);
        }

    }

    @Override
    public List<User> getAllUsers() {
     List<User>users = entityManager.createQuery("select u from User u",User.class).getResultList();
        return users;
    }

    @Override
    public void cleanUsersTable() {
         entityManager.getTransaction().begin();
         entityManager.createQuery("delete from User").executeUpdate();
         entityManager.clear();
         entityManager.getTransaction().commit();

    }


}
