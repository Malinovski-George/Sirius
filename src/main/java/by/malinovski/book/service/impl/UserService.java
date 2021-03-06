package by.malinovski.book.service.impl;

import by.malinovski.book.dao.UserDao;
import by.malinovski.book.dto.UserDto;
import by.malinovski.book.exceptions.EmailExistsException;
import by.malinovski.book.model.Role;
import by.malinovski.book.model.User;
import by.malinovski.book.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Autowired private UserDao repository;

  @Override
  public User getUserByEmail(String email) {
    return repository.getUserByEmail(email);
  }

  @Override
  public String getUserEmail(String userName) {
    return null;
  }

  @Override
  public void registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
    if (isEmailExist(accountDto.getEmail())) {
      throw new EmailExistsException(
          "There is no an account with that email address: " + accountDto.getEmail());
    }
    User user = new User();
    user.setName(accountDto.getFirstName());
    user.setPassword(accountDto.getPassword());
    user.setEmail(accountDto.getEmail());
    user.setRole(Role.ROLE_ADMIN);
    repository.save(user);
  }

  private boolean isEmailExist(String email) {
    User user = repository.getUserByEmail(email);
    if (user != null) {
      return true;
    }
    return false;
  }
}
