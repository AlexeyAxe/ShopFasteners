package org.example.shop.repository.impl;

import org.example.shop.model.Brand;
import org.example.shop.repository.BrandRepository;
import org.example.shop.repository.mapper.impl.BrandMapperImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BrandRepositoryImpl implements BrandRepository {

    private final Connection connection;
    private BrandMapperImpl brandMapper;

    private static final String FIND_BY_ID = "SELECT * FROM Brand WHERE id_brand = ?";
    private static final String FIND_ALL = "SELECT * FROM Brand";
    private static final String DELETE_BY_ID = "DELETE * FROM Brand WHERE idbrand = ?";
    private static final String SAVE = "INSERT INTO Brand(idbrand,brandName) VALUES = (?,?)";
    public BrandRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Brand> findById(Long id)  {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(brandMapper.mapToBrand(resultSet));
                }
                     return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
        public boolean deleteById (Long id){
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
                preparedStatement.setLong(1, id);
                return preparedStatement.executeUpdate()>0;
                }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<Brand> findAll () {
            List<Brand>brands=new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
               ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Brand brand = new Brand();
                        brand.setBrandName(resultSet.getString("brand_name"));
                        brand.setIdBrand(resultSet.getLong("id_brand"));
                        brands.add(brand);
                    }
                return brands;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean save (Brand brand){
            try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
                preparedStatement.setLong(1, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(2, brand.getBrandName());
                return preparedStatement.executeUpdate()>0;
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
