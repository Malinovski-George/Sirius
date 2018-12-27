package by.malinovski.book.service;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IFlatService {

    void saveNewFlat(SimpleFlatDto registrationFormDto, User user);

    List<SimpleFlatDto> getAllFlats();
}
