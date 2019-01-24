package by.malinovski.book.dao;

import by.malinovski.book.model.User;

public interface UserDao {

  User getUserByEmail(String email);

  User getUserByName(String userName);

  String getUserEmail(String userName);

  User getUserById(int owner);

  void save(User user);
}
