package com.company.dao.impl;

import com.company.dao.StoreDao;
import com.company.model.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    @Override
    public void save(Store store) {


    }

    @Override
    public Store findById(long id) {
        return null;
    }

    @Override
    public void saveAll(List<Store> stores) {

    }

    @Override
    public List<Store> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        List<Store> stores = new ArrayList<>();

        try {
            String query = "SELECT * FROM store";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Store store = new Store();
                store.setId(resultSet.getLong("id"));
                store.setName(resultSet.getString("name"));
                store.setAddress(resultSet.getString("address"));
                store.setPhone(resultSet.getString("phone"));
                store.setEmail(resultSet.getString("email"));
                stores.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return stores;
    }

    @Override
    public void delete(long id) {

    }
}
