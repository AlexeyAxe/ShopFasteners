package org.axenov.shop.repository.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.repository.BrandRepository;
import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.mapper.impl.BrandMapperImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BrandRepositoryImpl implements BrandRepository {

    private final ConnectionManager connectionManager;
    private BrandMapperImpl brandMapper;

    private static final String FIND_BY_ID = "SELECT * FROM brand WHERE id_brand = ?";
    private static final String FIND_ALL = "SELECT * FROM brand";
    private static final String DELETE_BY_ID = "DELETE * FROM brand WHERE id_brand = ?";
    private static final String SAVE = "INSERT INTO brand(id_brand,name_brand) VALUES (?,?)";

    public BrandRepositoryImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Brand findById(Long id) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return brandMapper.mapToBrand(resultSet);
           }
         return null;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not found brand by ID", e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not delete brand", e);
        }
    }

    @Override
    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                brands.add(brandMapper.mapToBrand(resultSet));
            }
            return brands;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not found all brand by ID", e);
        }
    }

    @Override
    public boolean save(Brand brand) {
        boolean result;
        try (PreparedStatement preparedStatement = connectionManager
                .getConnection().prepareStatement(SAVE)) {
            preparedStatement.setLong(1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(2, brand.getNameBrand());
            result= preparedStatement.executeUpdate() > 0;
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Not save brand", e);
        }
        return result;
    }
}
