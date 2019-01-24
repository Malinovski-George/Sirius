package by.malinovski.book.service.impl;

import by.malinovski.book.dao.impl.PriceDao;
import by.malinovski.book.model.Price.Price;
import by.malinovski.book.service.IPriceService;

import org.springframework.beans.factory.annotation.Autowired;

public class PriceService implements IPriceService {

  @Autowired PriceDao priceDao;

  @Override
  public void save(Price price) {
    priceDao.save(price);
  }
}
