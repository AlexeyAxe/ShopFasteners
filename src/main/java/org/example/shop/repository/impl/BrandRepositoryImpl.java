package org.example.shop.repository.impl;

import org.example.shop.db.ConnectionManagerImpl;
import org.example.shop.model.Brand;
import org.example.shop.repository.BrandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrandRepositoryImpl implements BrandRepository {

    private final Connection connection;


    private static final String FIND_BY_ID = "SELECT * FROM Brand WHERE idbrand = ?";
    private static final String FIND_ALL = "SELECT * FROM Brand";

    public BrandRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Brand> findById(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Brand brand = new Brand();
                    brand.setBrandName(resultSet.getString("brand_name"));
                    brand.setIdBrand(resultSet.getLong("id_brand"));
                    return Optional.of(brand);
                }
            }
            return Optional.empty();
        }
    }

        @Override
        public boolean deleteById (Integer id){
            return false;
        }

        @Override
        public List<Brand> findAll () {
            List<Brand>brands=new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Brand brand = new Brand();
                        brand.setBrandName(resultSet.getString("brand_name"));
                        brand.setIdBrand(resultSet.getLong("id_brand"));

                    }
                }
                return brands;
            }
        }

        @Override
        public Brand save (Brand brand){
            return null;
        }
    }
