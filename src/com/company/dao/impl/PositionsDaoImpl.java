package com.company.dao.impl;

import com.company.dao.PositionsDao;
import com.company.model.Genre;
import com.company.model.Positions;

import java.sql.*;
import java.util.List;

public class PositionsDaoImpl implements PositionsDao {
    @Override
    public void save(Positions positions) {

    }


    @Override
    public Positions findById(long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        Positions positions = null;

        try {
            String query = "SELECT * FROM positions WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            positions = new Positions();
            positions.setId(resultSet.getLong("id"));
            positions.setName(resultSet.getString("name"));
            positions.setActive(resultSet.getBoolean("is_active"));


            System.out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return positions;
    }

    @Override
    public void saveAll(List<Positions> positions) {

    }

    @Override
    public List<Positions> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
