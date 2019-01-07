package by.malinovski.book.dao.impl;

import by.malinovski.book.dao.IPriceDao;
import by.malinovski.book.model.Price.Price;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PriceDao implements IPriceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Price price) {
        Session session = sessionFactory.getCurrentSession();
        session.save(price);
    }

    @Override
    public void update(Price price) {
        Session session = sessionFactory.getCurrentSession();
        session.update(price);
    }
}
