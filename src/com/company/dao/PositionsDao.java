package com.company.dao;

import com.company.dao.impl.PositionsDaoImpl;
import com.company.model.Positions;

import java.util.List;

public interface PositionsDao extends CrudDao<Positions>{

    PositionsDao INSTANCE = new PositionsDaoImpl();

}
