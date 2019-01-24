package by.malinovski.book.service;

import by.malinovski.book.dto.UserDto;
import by.malinovski.book.exceptions.EmailExistsException;
import by.malinovski.book.model.User;

public interface IUserService {
  User getUserByEmail(String email);

  String getUserEmail(String userName);

  void registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
