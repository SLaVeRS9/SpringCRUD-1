package ru.slavers9.springCRUD_2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.slavers9.springCRUD_2.models.UserModel;

import java.util.List;

@Repository
public class UserRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<UserModel> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query<UserModel> users = session.createQuery("SELECT u FROM UserModel u", UserModel.class);
        return users.getResultList();
    }

    @Transactional(readOnly = true)
    public UserModel getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserModel.class, id);
    }

    @Transactional
    public void editUser(UserModel user, Long id) {
        Session session = sessionFactory.getCurrentSession();
        UserModel editableUser = session.get(UserModel.class, id);
        session.merge(user);
    }

    @Transactional
    public void addUser(UserModel user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        UserModel userToRemove = session.get(UserModel.class, id);
        session.remove(userToRemove);
    }
}
