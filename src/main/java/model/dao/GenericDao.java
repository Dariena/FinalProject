package model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> extends AutoCloseable{

    //Create
    T create(T entity);

    //Read
    T findById(int id);
    List<T> findAll();

    //Update
    void update(T t);

    //Delete
    void delete(int id);

    //Close
    void close();

}
