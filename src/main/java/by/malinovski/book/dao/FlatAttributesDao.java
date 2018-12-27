package by.malinovski.book.dao;


import by.malinovski.book.model.attributes.FlatAttributes;
import by.malinovski.book.model.attributes.SimpleAttributes;

public interface FlatAttributesDao {

    int createAttributes(FlatAttributes attributes);

    FlatAttributes getFlatAttributesById(int id);

    boolean updateAttributes(FlatAttributes attributes);

    void save(FlatAttributes flatAttributes);

    void save(SimpleAttributes simpleAttr);
}
