package by.malinovski.book.service;


import by.malinovski.book.model.User;

public interface UserService {
    User getUserByEmail(String email);

    String getUserEmail(String userName);
}
