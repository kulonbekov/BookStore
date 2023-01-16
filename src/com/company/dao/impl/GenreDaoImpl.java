package com.company.dao.impl;

import com.company.dao.GenreDao;
import com.company.model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao {
    @Override
    public void save(Genre genre) {
        PreparedStatement preparedStatement = null;
        Connection connection = getConnection();
        try {
            String query = ""+
                    "INSERT INTO genre(name) " +
                    "VALUES (?) ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,genre.getName());
            preparedStatement.execute();


            System.out.println("Connection succeed");

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }

    }

    @Override
    public Genre findById(long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        Genre genre = null;

        try {
            String query = "SELECT * FROM genre WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            genre = new Genre();
            genre.setId(resultSet.getLong("id"));
            genre.setName(resultSet.getString("name"));


            System.out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return genre;
    }

    @Override
    public void saveAll(List<Genre> genres) {
        for (int i = 0; i < genres.size(); i++){
            save(genres.get(i));
        }
    }

    @Override
    public List<Genre> findAll() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        List<Genre> genres = new ArrayList<>();

        try {
            String query = "SELECT * FROM genre";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Genre genre = new Genre();
                genre.setId(resultSet.getLong("id"));
                genre.setName(resultSet.getString("name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return genres;
    }

    @Override
    public void delete(long id) {
        PreparedStatement preparedStatement = null;
        Connection connection = getConnection();
        try {
            String query = "DELETE FROM genre WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }
}
