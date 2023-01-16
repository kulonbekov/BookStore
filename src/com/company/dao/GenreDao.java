package com.company.dao;

import com.company.dao.impl.GenreDaoImpl;
import com.company.model.Genre;

public interface GenreDao extends CrudDao<Genre> {
    GenreDao INSTANCE = new GenreDaoImpl();



}
