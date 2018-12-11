package by.malinovski.book.service;

import by.malinovski.book.dao.UserDao;
import by.malinovski.book.dto.UserDto;
import by.malinovski.book.exceptions.EmailExistsException;
import by.malinovski.book.model.Role;
import by.malinovski.book.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao repository;

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public String getUserEmail(String userName) {
        return null;
    }

    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (isEmailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is no an account with that email address: " + accountDto.getEmail());
        }
        User user = new User();
        user.setName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
//        user.setRoles(Arrays.asList("ROLE_USER"));
        user.setRole(Role.ROLE_ADMIN);
        return repository.save(user);
    }

    private boolean isEmailExist(String email) {
        User user = repository.getUserByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}

