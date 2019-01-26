package by.malinovski.book.dao.impl;

import by.malinovski.book.dao.FlatAttributesDao;
import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.attributes.SimpleAttributes;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
@javax.persistence.Cacheable
public class FlatAttributesDao_Impl implements FlatAttributesDao {

  private SessionFactory sessionFactory;

  public FlatAttributesDao_Impl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public int createAttributes(FlatAttributes attributes) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(attributes);
  }

  @Override
  public FlatAttributes getFlatAttributesById(int id) {

    Session session = null;
    List<FlatAttributes> attributes = null;
    session = sessionFactory.getCurrentSession();
    Query query =
        session
            .createQuery("from FlatAttributes where ID=:attrId")
            .setString("attrId", String.valueOf(id));
    return (FlatAttributes) query.list();
  }

  @Override
  public boolean updateAttributes(FlatAttributes attributes) {
    return false;
  }

  @Override
  public void save(FlatAttributes flatAttributes) {
    Session session = null;
    session = sessionFactory.getCurrentSession();
    session.save(flatAttributes);
  }

  @Override
  public void save(SimpleAttributes simpleAttr) {
    Session session = sessionFactory.getCurrentSession();
    session.save(simpleAttr);
  }
}
