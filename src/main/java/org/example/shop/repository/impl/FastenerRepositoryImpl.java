package org.example.shop.repository.impl;

import org.example.shop.model.Fastener;
import org.example.shop.repository.FastenerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FastenerRepositoryImpl implements FastenerRepository {

    private final Connection connection;
    private static final String FIND_BY_ID = "SELECT * FROM fastener WHERE id_fastener = ?";
    private static final String FIND_ALL = "SELECT * FROM fastener";
    private static final String DELETE_BY_ID = "DELETE * FROM fastener WHERE id_fastener = ?";
    private static final String SAVE = "INSERT INTO fastener(id_fastener,name_fastener) VALUES = (?,?)";

    public FastenerRepositoryImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Optional<Fastener> findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Fastener fastener = new Fastener();
                fastener.setNameFastener(resultSet.getString("name_fastener"));
                fastener.setIdFastener(resultSet.getLong("id_fastener"));
                return Optional.of(fastener);
            }
            return Optional.empty();
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
                Fastener fastener = new Fastener();
                fastener.setNameFastener(resultSet.getString("name_fastener"));
                fastener.setIdFastener(resultSet.getLong("id_fastener"));
                fastenersList.add(fastener);
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
