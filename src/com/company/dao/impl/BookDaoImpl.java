package com.company.dao.impl;

import com.company.dao.BookDao;
import com.company.model.Book;
import com.company.model.Genre;
import com.company.model.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void save(Book book) {


    }

    @Override
    public Book findById(long id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = new Book();
        try {
            String query = "" +
                    "select " +
                    "    b.id as b_id, " +
                    "    b.name as b_name, " +
                    "    b.author, " +
                    "    b.price, " +
                    "    g.id as g_id, " +
                    "    g.name as g_name, " +
                    "    s.id as s_id, " +
                    "    s.name as s_name, address, phone, email " +
                    "    from book as b " +
                    "left join genre as g on g.id = b.genre_id " +
                    "left join store as s on s.id = b.store_id " +
                    "where b.id = ?";


            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            book.setId(resultSet.getLong("b_id"));
            book.setAuthor(resultSet.getString("author"));
            book.setName(resultSet.getString("b_name"));
            book.setPrice(resultSet.getBigDecimal("price"));

            Genre genre = new Genre();
            genre.setId(resultSet.getLong("g_id"));
            genre.setName(resultSet.getString("g_name"));
            book.setGenre(genre);

            Store store = new Store();
            store.setId(resultSet.getLong("s_id"));
            store.setName(resultSet.getString("s_name"));
            store.setAddress(resultSet.getString("address"));
            store.setEmail(resultSet.getString("email"));
            store.setPhone(resultSet.getString("phone"));
            book.setStore(store);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return book;
    }

    @Override
    public void saveAll(List<Book> books) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
