package org.example.shop.repository;

import org.example.shop.model.Brand;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SimpleRepository<T,K> {
    Optional<T> findById(K id);

    boolean deleteById(K id);

    List<T> findAll() ;

    boolean save(T t);
}
