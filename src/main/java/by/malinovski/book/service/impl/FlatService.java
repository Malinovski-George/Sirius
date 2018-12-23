package by.malinovski.book.service.impl;

import by.malinovski.book.dao.FlatAttributesDao;
import by.malinovski.book.dao.FlatDao;
import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.FlatAttributes;
import by.malinovski.book.model.User;
import by.malinovski.book.service.IFlatService;
import by.malinovski.book.util.convertors.SimpleFlatConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlatService implements IFlatService {

    @Autowired
    SimpleFlatConvertor flatConvertor;

    @Autowired
    FlatDao flatDao;

    @Autowired
    FlatAttributesDao attrDao;


    @Override
    public void saveNewFlat(SimpleFlatDto simpleFlatDto, User user) {
        Flat flat = flatConvertor.getFlat(simpleFlatDto);
        FlatAttributes flatAttributes = flatConvertor.getFlatAttributes(simpleFlatDto);

        flatAttributes.setFlat(flat);
        flat.setFlatAttributes(flatAttributes);
        flat.setFlatOwner(user);

        flatDao.save(flat);
        attrDao.save(flatAttributes);
    }
}
