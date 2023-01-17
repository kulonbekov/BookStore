package com.company;

import com.company.dao.*;
import com.company.model.Salary;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenreDao genreDao = DaoContext.getGenreDao();
        BookDao bookDao = DaoContext.getBookDao();
        StoreDao storeDao = DaoContext.getStoreDao();
        SalaryDao salaryDao = DaoContext.getSalaryDao();
        PositionsDao positionsDao = DaoContext.getPositionsDao();
        EmployeeDao employeeDao = DaoContext.getEmployeeDao();

        //GENRE
        //System.out.println("Список всех жанров");
        //System.out.println(genreDao.findAll());

        //BOOK
        //System.out.println("Найти книгу по ID");
        //System.out.println(bookDao.findById(1l));

        //STORE
        //System.out.println("Список всех магазинов");
        //System.out.println(storeDao.findAll());

        //SALARY
        /*System.out.println("Сохранить запись в Salary");
        Salary salary = new Salary();
        salary.setSum(BigDecimal.valueOf(50000));
        salaryDao.save(salary);*/

        //POSITIONS
        //System.out.println("Найти позицию по ID");
        //System.out.println(positionsDao.findById(1));

        System.out.println("Вывод всех позиции");
        System.out.println(positionsDao.findAll());

        //EMPLOYEE
        //System.out.println("Вывод всех сотрудников");
        //System.out.println(employeeDao.findAll());

    }
}