package be.intecbrussel.quize.dao;

import java.util.List;

public interface QuizDao<T> {
    List getList();
    void create(T t);
    void delete(T t);
    void update(T t);
}
