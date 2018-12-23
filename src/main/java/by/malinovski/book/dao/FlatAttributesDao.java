package by.malinovski.book.dao;


import by.malinovski.book.model.FlatAttributes;

public interface FlatAttributesDao {

    int createAttributes(FlatAttributes attributes);

    FlatAttributes getFlatAttributesById(int id);

    boolean updateAttributes(FlatAttributes attributes);

    void save(FlatAttributes flatAttributes);
}
