package by.malinovski.book.dao.impl;



import by.malinovski.book.dao.UserDao;
import by.malinovski.book.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao_Impl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*public UserDao_Impl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
*/
    @Override
    public User getUserByEmail(String email) {
        User user = null;
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email =:userEmail")
                .setString("userEmail", email);
        List<User> list = (List<User>) query.list();
        for (User user1 : list) {
            user = user1;
        }
        return user;
    }

    @Override
    public User getUserByName(String userName) {
        User user = null;
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User where NAME =:userName")
                .setString("userName", userName);
        return  (User) query.list().stream().findFirst().orElse(null);
    }

    @Override
    public String getUserEmail(String userName) {

        User user = getUserByName(userName);
//        return user.getEmail();

    return null;
    }

   /* @Override
    public List<User> getAllEngineers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where ROLE_ID =:roleId")
                .setString("roleId", String.valueOf(Role.ROLE_ENGINEER.ordinal()));
        return (List<User>) query.list();
    }

    @Override
    public List<User> getAllManagers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where ROLE_ID =:roleId")
                .setString("roleId", String.valueOf(Role.ROLE_MANAGER.ordinal()));
        return (List<User>) query.list();
    }*/

    @Override
    public User getUserById(int userId) {
        User user = null;
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where ID =:userId")
                .setString("userId", String.valueOf(userId));
        return (User) query.list().stream().findFirst().orElse(null);
    }

    @Override
    public User save(User user) {
        return user;
    }
}

