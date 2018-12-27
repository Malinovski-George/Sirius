package by.malinovski.book.service.impl;

import by.malinovski.book.dao.FlatAttributesDao;
import by.malinovski.book.dao.FlatDao;
import by.malinovski.book.dao.impl.PriceDao;
import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.Price.Price;
import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.User;
import by.malinovski.book.model.attributes.SimpleAttributes;
import by.malinovski.book.service.IFlatService;
import by.malinovski.book.util.convertors.SimpleFlatConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FlatService implements IFlatService {

    @Autowired
    SimpleFlatConvertor flatConvertor;

    @Autowired
    FlatDao flatDao;

    @Autowired
    FlatAttributesDao attrDao;

    @Autowired
    PriceDao priceDao;


    @Override
    public void saveNewFlat(SimpleFlatDto simpleFlatDto, User user) {
        Flat flat = flatConvertor.getFlat(simpleFlatDto);
        SimpleAttributes simpleAttr = flatConvertor.getSimpleAttributes(simpleFlatDto);
        Price price = new Price();
        FlatAttributes flatAttr = new FlatAttributes();

        price.setPriceDay(new BigDecimal(simpleFlatDto.getPriceDay()));
        simpleAttr.setFlat(flat);
        simpleAttr.setPrice(price);
        flatAttr.setFlat(flat);
        flatAttr.setPrice(price);
        flat.setFlatAttributes(flatAttr);
        flat.setSimpleAttributes(simpleAttr);
        flat.setFlatOwner(user);

        priceDao.save(price);

        flatDao.save(flat);
//        attrDao.save(flatAttr);
//        attrDao.save(simpleAttr);

    }

    @Override
//    public List<Flat> getAllFlats() {
    public List<SimpleFlatDto> getAllFlats() {
        // TODO GM: simple
        List<Flat> flats = flatDao.getAllFlats();
        List<SimpleFlatDto> flatsDto = flatConvertor.getFlatsDto(flats);

        return flatsDto;
    }

}
