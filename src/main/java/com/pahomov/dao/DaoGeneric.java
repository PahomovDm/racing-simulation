package com.pahomov.dao;

import java.io.Serializable;
import java.util.List;

public interface DaoGeneric<T extends Identified<PK>, PK extends Serializable> {

    // создать
    void create(T newInstance) throws PersistException;

    // считать по ид
    T read(PK id) throws PersistException;

    // обновить
    void update(T transientObject) throws PersistException;

    // удалить
    void delete(int id) throws PersistException;

    List<T> getAll() throws PersistException;
}
