package by.malinovski.book.dao;

import by.malinovski.book.model.Photos.FlatPhoto;

import java.util.Set;

public interface IPhotoDao {
    void save(Set<FlatPhoto> photos);

    void save(FlatPhoto photo);

    FlatPhoto getPhotoById(String id);
}
