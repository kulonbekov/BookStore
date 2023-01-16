package com.company.dao;

import com.company.dao.impl.*;

import java.util.logging.Logger;

public abstract class DaoContext {
    static {
        Logger logger = Logger.getLogger(DaoContext.class.getName());
        try {
            logger.info("Loading driver");
            Class.forName("org.postgresql.Driver");
            logger.info("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static GenreDao getGenreDao(){
        return new GenreDaoImpl();
    }
    public static PositionsDao getPositionsDao(){ return new PositionsDaoImpl();}
    public static BookDao getBookDao() {
        return new BookDaoImpl();
    }
    public static StoreDao getStoreDao(){return new StoreDaoImpl();}
    public static SalaryDao getSalaryDao(){return new SalaryDaoImpl();}
    public static EmployeeDao getEmployeeDao(){return new EmployeeDaoImpl();}


}
