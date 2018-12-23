package by.malinovski.book.service;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.User;
import org.springframework.stereotype.Component;

@Component
public interface IFlatService {

    void saveNewFlat(SimpleFlatDto registrationFormDto, User user);
}
