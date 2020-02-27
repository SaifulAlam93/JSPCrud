/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.User;
import model.SystemUser;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Repository
@Transactional
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

//    public User getUserByIdAndPasswordFromDB(String userId) {
//
//        String sql = "Select a from User a where a.userId=:userId ";
//        Query query = sessionFactory.getCurrentSession().createQuery(sql);
//        query.setParameter("userId", userId);
//        if (query.list().size() > 0) {
//            return (User) query.list().get(0);
//        }
//        return null;
//    }
 public User getUserByUserIdFromDB(String userId) {

        String sql = "Select a from User a where a.userId=:userId ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("userId", userId);
        if (query.list().size() > 0) {
            return (User) query.list().get(0);
        }
        return null;
    }

    public User getUserByIdFromDB(Long id) {

        String sql = "Select a from User a where a.id=:id ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("id", id);
        if (query.list().size() > 0) {
            return (User) query.list().get(0);
        }
        return null;
    }

    public boolean insertUserInToDB(User user) {

        sessionFactory.getCurrentSession().save(user);

        return true;
    }

    public boolean updateUserInDB(User user) {

        sessionFactory.getCurrentSession().update(user);

        return true;

    }

    public boolean removeUserFromDB(User user) {
        sessionFactory.getCurrentSession().remove(user);

        return true;

    }

    public List<User> getAllUserFromDB(Integer pageID) {

        String sql = "Select a from User a ";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);

        query.setFirstResult(pageID);
        query.setMaxResults(10);

        return query.list();
    }

}
