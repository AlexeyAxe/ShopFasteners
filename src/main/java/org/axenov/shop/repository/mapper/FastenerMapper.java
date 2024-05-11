package org.axenov.shop.repository.mapper;

import org.axenov.shop.model.Fastener;

import java.sql.ResultSet;

public interface FastenerMapper {
    Fastener mapToFastener(ResultSet resultSet);
}
