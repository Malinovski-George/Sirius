package by.malinovski.book.service.impl;

import by.malinovski.book.dao.FlatAttributesDao;
import by.malinovski.book.dao.FlatDao;
import by.malinovski.book.dao.impl.PhotoDao;
import by.malinovski.book.dao.impl.PriceDao;
import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.Photos.FlatPhoto;
import by.malinovski.book.model.Price.Price;
import by.malinovski.book.model.Role;
import by.malinovski.book.model.User;
import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.attributes.SimpleAttributes;
import by.malinovski.book.service.IFlatService;
import by.malinovski.book.util.convertors.PhotoConvertor;
import by.malinovski.book.util.convertors.SimpleFlatConvertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class FlatService implements IFlatService {

  @Autowired SimpleFlatConvertor flatConvertor;

  @Autowired PhotoConvertor photoConvertor;

  @Autowired FlatDao flatDao;

  @Autowired FlatAttributesDao attrDao;

  @Autowired PriceDao priceDao;

  @Autowired PhotoDao photoDao;

  @Override
  public void saveNewFlat(SimpleFlatDto simpleFlatDto, User user) throws IOException {
    Flat flat = flatConvertor.getFlat(simpleFlatDto);
    SimpleAttributes simpleAttr = flatConvertor.getSimpleAttributes(simpleFlatDto);
    Set<FlatPhoto> photos = photoConvertor.getPhotosFromDto(simpleFlatDto, flat);

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

    photoDao.save(photos);
  }

  @Override
  public List<SimpleFlatDto> getAllSimpleFlatsDto() {
    List<Flat> flats = flatDao.getAllFlats();
    return flatConvertor.getFlatsDto(flats);
  }

  @Override
  public boolean canDelete(User user, Integer flatId) {

    if (Role.ROLE_ADMIN.equals(user.getRole())) {
      return true;
    }

    if (user.equals(flatDao.getFlatById(flatId).getFlatOwner())) {
      return true;
    }

    return false;
  }

  @Override
  public boolean canUpdate(User user, Integer flatId) {
    if (Role.ROLE_ADMIN.equals(user.getRole())) {
      return true;
    }

    if (user.equals(flatDao.getFlatById(flatId).getFlatOwner())) {
      return true;
    }

    return false;
  }

  @Override
  public void delete(Integer flatId) {
    flatDao.delete(flatId);
  }

  @Override
  public List<SimpleFlatDto> getSimpleFlatDtoByUser(User user) {
    return flatConvertor.getFlatsDto(flatDao.getFlatsByUser(user));
  }

  @Override
  public SimpleFlatDto getSimpleFlatDtoById(Integer flatId) {

    return flatConvertor.getFlatDto(flatDao.getFlatById(flatId));
  }

  @Override
  public void updateFlat(SimpleFlatDto simpleFlatDto, Integer flatId) {

    Flat flat = flatDao.getFlatById(flatId);
    flat = flatConvertor.updateFlatWithDto(flat, simpleFlatDto);

    SimpleAttributes simpleAttr = flat.getSimpleAttributes();

    simpleAttr = flatConvertor.updateSimpleAttributesWithDto(simpleAttr, simpleFlatDto);

    Price price = simpleAttr.getPrice();
    FlatAttributes flatAttr = flat.getFlatAttributes();

    price.setPriceDay(new BigDecimal(simpleFlatDto.getPriceDay()));
    priceDao.update(price);

    flatDao.update(flat);
  }
}
