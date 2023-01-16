package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface CrudDao<Model> {


    void save(Model model);
    Model findById(long id);
    void saveAll(List<Model> models);
    List<Model> findAll();
    void delete(long id);

    default Connection getConnection()  {
        final String URL = "jdbc:postgresql://localhost:5432/book_store";
        final String USERNAME = "postgres";
        final String PASSWORD = "postgres";
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return null;
        }
    }

    default void close(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            System.out.println("Closing connection finish");
            e.printStackTrace();
        }
    }

}
