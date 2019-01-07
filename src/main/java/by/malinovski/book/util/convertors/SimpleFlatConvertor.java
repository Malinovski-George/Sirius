package by.malinovski.book.util.convertors;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.attributes.SimpleAttributes;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SimpleFlatConvertor {

    public Flat getFlat(SimpleFlatDto simpleFlatDto) {
        Flat flat = new Flat();
        return updateFlatWithDto(flat, simpleFlatDto);
    }

    public Flat updateFlatWithDto(Flat flat, SimpleFlatDto simpleFlatDto) {
        flat.setStreet(simpleFlatDto.getStreet());
        // TODO GM: names!
        flat.setCity(simpleFlatDto.getTown());
        flat.setHouse(simpleFlatDto.getHouseNumber());
        flat.setOwnerName(simpleFlatDto.getOwnerName());
        flat.setDescriptionShort(simpleFlatDto.getDescriptionShort());
        flat.setPhone1(simpleFlatDto.getPhone1());
        flat.setPhone2(simpleFlatDto.getPhone2());
        flat.setPhone3(simpleFlatDto.getPhone3());

        return flat;
    }

    @Deprecated
    // until using full attributes
    public FlatAttributes getFlatAttributes(SimpleFlatDto simpleFlatDto) {

        FlatAttributes attr = new FlatAttributes();
       /* attr.setGeneralArea(simpleFlatDto.getGeneralArea());
        attr.setKitchenArea(simpleFlatDto.getKitchenArea());
        attr.setBedNumber(simpleFlatDto.getGuestsNumber());
        attr.setMultistorey(simpleFlatDto.getMultistorey());
        attr.setRoomNumber(simpleFlatDto.getRoomNumber());*/
        return attr;

    }

    public SimpleAttributes getSimpleAttributes(SimpleFlatDto simpleFlatDto) {
        SimpleAttributes attr = new SimpleAttributes();
        return updateSimpleAttributesWithDto(attr, simpleFlatDto);
    }


    public SimpleAttributes updateSimpleAttributesWithDto(SimpleAttributes attr, SimpleFlatDto simpleFlatDto) {
        attr.setGeneralArea(simpleFlatDto.getGeneralArea());
        attr.setKitchenArea(simpleFlatDto.getKitchenArea());
        attr.setLifeArea(simpleFlatDto.getLifeArea());
        attr.setGuestsNumber(simpleFlatDto.getGuestsNumber());
        attr.setMultistorey(simpleFlatDto.getMultistorey());
        attr.setRoomNumber(simpleFlatDto.getRoomNumber());
        attr.setBedNumber(simpleFlatDto.getBedNumber());

        return attr;
    }



    public List<SimpleFlatDto> getFlatsDto(List<Flat> flats) {
        List<SimpleFlatDto> resList = new LinkedList<>();

        for (Flat flat : flats) {
            resList.add(getFlatDto(flat));
        }
        return resList;
    }

    public SimpleFlatDto getFlatDto(Flat flat) {

        SimpleFlatDto flatDto = new SimpleFlatDto();
        flatDto.setId(flat.getId());
        flatDto.setOwnerName(flat.getOwnerName());
        // TODO GM: add phones
//            flatDto.setPhone1(flat.get);
        flatDto.setStreet(flat.getStreet());
        // TODO GM: not EQUALS
        flatDto.setHouseNumber(flat.getHouse());
        // TODO GM: not EQUALS
        flatDto.setCountry(flat.getCity());
        flatDto.setTown(flat.getCity());
        flatDto.setDescriptionShort(flat.getDescriptionShort());
        flatDto.setPhone1(flat.getPhone1());
        flatDto.setPhone2(flat.getPhone2());
        flatDto.setPhone3(flat.getPhone3());

        if (flat.getPhotos() != null) {
            flatDto.setMainPhotoId(flat.getPhotos().stream().findFirst().get().getId());
        }
        SimpleAttributes simpleAttributes = flat.getSimpleAttributes();
        flatDto.setRoomNumber(simpleAttributes.getRoomNumber());
        flatDto.setMultistorey(simpleAttributes.getMultistorey());
        flatDto.setGeneralArea(simpleAttributes.getGeneralArea());
        flatDto.setLifeArea(simpleAttributes.getLifeArea());
        flatDto.setKitchenArea(simpleAttributes.getKitchenArea());
        flatDto.setGuestsNumber(simpleAttributes.getGuestsNumber());
        flatDto.setBedNumber(simpleAttributes.getBedNumber());
        if (simpleAttributes.getPrice() != null) {
            flatDto.setPriceDay(simpleAttributes.getPrice().getPriceDay().longValue());
        } else {
            flatDto.setPriceDay(0);
        }
        return flatDto;
    }
}
