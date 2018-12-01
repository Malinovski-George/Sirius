package by.malinovski.book.dao.impl;


import by.malinovski.book.dao.FlatDao;
import by.malinovski.book.model.Flat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlatDao_Impl implements FlatDao {

    private SessionFactory sessionFactory;

    public FlatDao_Impl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int createFlat(Flat flat) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(flat);
    }

    @Override
    public List<Flat> getAllFlats() {
        List<Flat> flats = null;
        Session session = sessionFactory.getCurrentSession();
        flats = session.createCriteria(Flat.class).list();
        return flats;

    }

    @Override
    public Flat getFlatById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Flat) session.get(Flat.class, id);
    }

    @Override
    public List<Flat> getFlatsByUserId(int userId) {
        List<Flat> flats = null;
        Session session = sessionFactory.getCurrentSession();
        flats = session.createCriteria(Flat.class)
                .add(Restrictions.eq("id", userId))
                .list();
        return flats;
    }
}
