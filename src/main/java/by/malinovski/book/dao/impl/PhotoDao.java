package by.malinovski.book.dao.impl;

import by.malinovski.book.dao.IPhotoDao;
import by.malinovski.book.model.Photos.FlatPhoto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public class PhotoDao implements IPhotoDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  @Transactional
  public void save(Set<FlatPhoto> photos) {
    for (FlatPhoto photo : photos) {
      save(photo);
    }
  }

  @Override
  @Transactional()
  public void save(FlatPhoto photo) {
    Session session = sessionFactory.getCurrentSession();
    session.save(photo);
  }

  @Override
  public FlatPhoto getPhotoById(String id) {

    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from FlatPhoto where id =:id").setString("id", id);
    FlatPhoto photo = (FlatPhoto) query.getSingleResult();
    return photo;
  }
}
