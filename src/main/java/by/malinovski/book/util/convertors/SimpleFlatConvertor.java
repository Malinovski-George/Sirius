package by.malinovski.book.util.convertors;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.FlatAttributes;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SimpleFlatConvertor {
    public Flat getFlat(SimpleFlatDto simpleFlatDto) {

        Flat flat = new Flat();
        flat.setStreet(simpleFlatDto.getStreet());
        // TODO GM: names!
        flat.setCity(simpleFlatDto.getTown());
        flat.setHouse(simpleFlatDto.getHouseNumber());
        flat.setOwnerName(simpleFlatDto.getOwnerName());

        return flat;
    }

    public FlatAttributes getFlatAttributes(SimpleFlatDto simpleFlatDto) {

        FlatAttributes attr = new FlatAttributes();
        attr.setGeneralArea(simpleFlatDto.getGeneralArea());
        attr.setKitchenArea(simpleFlatDto.getKitchenArea());
        attr.setBedNumber(simpleFlatDto.getGuestsNumber());
        attr.setMultistorey(simpleFlatDto.getMultistorey());
        attr.setPriceHour(new BigDecimal(simpleFlatDto.getPriceHour()));
        attr.setPriceNight(new BigDecimal(simpleFlatDto.getPriceNight()));
        attr.setRoomNumber(simpleFlatDto.getRoomNumber());
        return attr;

    }
}
