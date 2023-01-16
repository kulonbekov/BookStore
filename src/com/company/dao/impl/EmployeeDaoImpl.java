package com.company.dao.impl;

import com.company.dao.EmployeeDao;
import com.company.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findById(long id) {
        return null;
    }

    @Override
    public void saveAll(List<Employee> employees) {

    }

    @Override
    public List<Employee> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        List<Employee> employees = new ArrayList<>();

        try {
            String query = "" +
                    "SELECT e.id as e_id, " +
                    "       e.name as e_name, " +
                    "       e.phone as e_phone, " +
                    "       p.id as p_id, " +
                    "       p.name as p_name, " +
                    "       p.is_active as is_active, " +
                    "       s.id as s_id, " +
                    "       s.sum as sum, " +
                    "       s.start_date as start_date, " +
                    "       s.end_date as end_date, " +
                    "       s2.id as s2_id, " +
                    "       s2.name as s2_name, " +
                    "       s2.address as address, " +
                    "       s2.phone as s2_phone, " +
                    "       s2.email as email " +
                    "FROM employee as e " +
                    "left join positions p on p.id = e.position_id " +
                    "left join salary s on s.id = e.salary_id " +
                    "left join store s2 on s2.id = e.store_id ";


            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Employee employee = new Employee();
                employee.setId(resultSet.getLong("e_id"));
                employee.setName(resultSet.getString("e_name"));
                employee.setPhone(resultSet.getString("e_phone"));

                Positions positions = new Positions();
                positions.setId(resultSet.getLong("p_id"));
                positions.setName(resultSet.getString("p_name"));
                positions.setActive(resultSet.getBoolean("is_active"));
                employee.setPositions(positions);

                Salary salary = new Salary();
                salary.setId(resultSet.getLong("s_id"));
                salary.setSum(resultSet.getBigDecimal("sum"));
                employee.setSalary(salary);

                Store store = new Store();
                store.setId(resultSet.getLong("s2_id"));
                store.setName(resultSet.getString("s2_name"));
                store.setAddress(resultSet.getString("address"));
                store.setPhone(resultSet.getString("s2_phone"));
                store.setEmail(resultSet.getString("email"));
                employee.setStore(store);

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return employees;
    }

    @Override
    public void delete(long id) {

    }
}
