package by.malinovski.book.dao;

import by.malinovski.book.model.Flat;
import by.malinovski.book.model.User;

import java.util.List;

public interface FlatDao {

  int createFlat(Flat flat);

  List<Flat> getAllFlats();

  Flat getFlatById(int id);

  List<Flat> getFlatsByUserId(int userId);

  void save(Flat flat);

  void delete(Integer flatId);

  List<Flat> getFlatsByUser(User user);

  void update(Flat flat);
}
