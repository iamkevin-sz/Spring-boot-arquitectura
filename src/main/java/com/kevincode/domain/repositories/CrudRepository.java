package com.kevincode.domain.repositories;

import java.util.List;

public interface CrudRepository<T> {
    public List<T> getAllItems();
    public T getById(Long id);  
    public T addItems(T t);
    void delete(Long id);
}
