package by.malinovski.book.service;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.User;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Component
public interface IFlatService {

    void saveNewFlat(SimpleFlatDto registrationFormDto, User user) throws IOException;

    List<SimpleFlatDto> getAllSimpleFlatsDto();

    boolean canDelete(User user, Integer flatId);

    boolean canUpdate(User user, Integer flatId);

    void delete(Integer flatId);

    List<SimpleFlatDto> getSimpleFlatDtoByUser(User user);

    SimpleFlatDto getSimpleFlatDtoById(Integer flatId);

    void updateFlat(SimpleFlatDto simpleFlatDto, Integer flatId);
}
