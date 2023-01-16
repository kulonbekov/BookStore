package com.company.dao.impl;

import com.company.dao.SalaryDao;
import com.company.model.Genre;
import com.company.model.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SalaryDaoImpl implements SalaryDao {
    @Override
    public void save(Salary salary) {
        PreparedStatement preparedStatement = null;
        Connection connection = getConnection();
        try {
            String query = ""+
                    "INSERT INTO salary(sum) " +
                    "VALUES (?) ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1,salary.getSum());
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
    public Salary findById(long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        Salary salary = null;

        try {
            String query = "SELECT * FROM salary WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            salary = new Salary();
            salary.setId(resultSet.getLong("id"));
            salary.setSum(resultSet.getBigDecimal("sum"));


            System.out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return salary;
    }

    @Override
    public void saveAll(List<Salary> salaries) {


    }

    @Override
    public List<Salary> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
