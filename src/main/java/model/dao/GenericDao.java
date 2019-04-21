package model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {

    T create(T entity);

    T findById(int id);

    List<T> findAll();

    void update(T t);

    void delete(int id);

    void close();

}
