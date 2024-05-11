package org.axenov.shop.repository;

import java.util.List;
import java.util.Optional;

public interface SimpleRepository<T,K> {
    Optional<T> findById(K id);

    boolean deleteById(K id);

    List<T> findAll() ;

    boolean save(T t);
}
