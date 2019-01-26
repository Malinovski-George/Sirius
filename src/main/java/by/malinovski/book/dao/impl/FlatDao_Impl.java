package by.malinovski.book.dao.impl;

import by.malinovski.book.dao.FlatDao;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@javax.persistence.Cacheable
public class FlatDao_Impl implements FlatDao {

  @Autowired private SessionFactory sessionFactory;

  public FlatDao_Impl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

  @Override
  public int createFlat(Flat flat) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(flat);
  }

  @Override
  @Cacheable(value = "flats")
  public List<Flat> getAllFlats() {
    logger.warn("Calling Repository method to retrieve event");
    List<Flat> flats = null;
    Session session = sessionFactory.getCurrentSession();
    flats = session.createCriteria(Flat.class).list();
    return flats;
  }

  @Override
  @Cacheable(value = "flat.byId", key = "#id")
  public Flat getFlatById(int id) {
    Session session = sessionFactory.getCurrentSession();
    Flat flat = session.get(Flat.class, id);
    return flat;
  }

  @Override
  public List<Flat> getFlatsByUserId(int userId) {
    List<Flat> flats = null;
    Session session = sessionFactory.getCurrentSession();
    flats = session.createCriteria(Flat.class).add(Restrictions.eq("flatOwner", userId)).list();
    return flats;
  }

  @Override
  public void save(Flat flat) {
    Session session = sessionFactory.getCurrentSession();

    session.save(flat);
  }

  @Override
  public void delete(Integer flatId) {
    Session session = sessionFactory.getCurrentSession();
    String hql = "delete Flat where id = :id";
    Query q = session.createQuery(hql).setParameter("id", flatId);
    q.executeUpdate();
  }

  @Override
  public List<Flat> getFlatsByUser(User user) {
    List<Flat> flats = null;
    Session session = sessionFactory.getCurrentSession();
    flats = session.createCriteria(Flat.class).add(Restrictions.eq("flatOwner", user)).list();
    return flats;
  }

  @Override
  public void update(Flat flat) {
    Session session = sessionFactory.getCurrentSession();
    session.update(flat);
  }
}
