package be.intecbrussel.littlearithmetics.dao;

import java.util.List;

public interface Dao<T> {
    List getList();
    void create(T t);
    void delete(T t);
    void update(T t);
}
