package org.axenov.shop.repository.impl;

import org.axenov.shop.repository.FastenerRepository;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.mapper.impl.FastenerMapperImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FastenerRepositoryImpl implements FastenerRepository {

    private final Connection connection;
    private FastenerMapperImpl fastenerMapper;
    private static final String FIND_BY_ID = "SELECT * FROM fastener WHERE id_fastener = ?";
    private static final String FIND_ALL = "SELECT * FROM fastener";
    private static final String DELETE_BY_ID = "DELETE * FROM fastener WHERE id_fastener = ?";
    private static final String SAVE = "INSERT INTO fastener(id_fastener,name_fastener) VALUES = (?,?)";

    public FastenerRepositoryImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Fastener findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

                return fastenerMapper.mapToFastener(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate()>0;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Fastener> findAll() {
        List<Fastener>fastenersList=new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            fastenersList.add(fastenerMapper.mapToFastener(resultSet));
            }
            return fastenersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Fastener fastener) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setLong(1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(2, fastener.getNameFastener());
            return preparedStatement.executeUpdate()>0;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
