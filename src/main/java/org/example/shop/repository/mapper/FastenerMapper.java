package org.example.shop.repository.mapper;

import org.example.shop.model.Fastener;

import java.sql.ResultSet;

public interface FastenerMapper {
    Fastener map(ResultSet resultSet);
}
