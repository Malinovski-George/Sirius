package by.malinovski.book.dao.impl;

import by.malinovski.book.dao.UserDao;
import by.malinovski.book.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class UserDao_Impl implements UserDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public User getUserByEmail(String email) {
    User user = null;
    Session session = this.sessionFactory.getCurrentSession();
    Query query =
        session.createQuery("from User where email =:userEmail").setString("userEmail", email);
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

    Query query =
        session.createQuery("from User where NAME =:userName").setString("userName", userName);
    return (User) query.list().stream().findFirst().orElse(null);
  }

  @Override
  public String getUserEmail(String userName) {

    User user = getUserByName(userName);
    //        return user.getEmail();

    return null;
  }

  @Override
  public User getUserById(int userId) {
    User user = null;
    Session session = this.sessionFactory.getCurrentSession();
    Query query =
        session
            .createQuery("from User where ID =:userId")
            .setString("userId", String.valueOf(userId));
    return (User) query.list().stream().findFirst().orElse(null);
  }

  @Override
  @Transactional
  public void save(User user) {
    Session session = sessionFactory.getCurrentSession();

    Serializable save = session.save(user);
  }
}
