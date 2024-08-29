package com.mycompany.app.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getAll();
    T getById(int id);
    void upsert(T product);
    void deleteById(int id);
}