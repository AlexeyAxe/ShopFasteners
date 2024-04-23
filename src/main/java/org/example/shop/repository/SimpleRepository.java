package org.example.shop.repository;

import java.sql.SQLException;
import java.util.Optional;

public interface SimpleRepository<T,K> {
    Optional<T> findById(K id) throws SQLException;

    boolean deleteById(K id);

    T findAll();

    T save(T t);
}
