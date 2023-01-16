package com.company.model;

public class Employee {

    private Long id;
    private String name;
    private String phone;
    private Positions positions;
    private Salary salary;
    private Store store;

    public Employee() {
    }

    public Employee(Long id, String name, String phone, Positions positions, Salary salary, Store store) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.positions = positions;
        this.salary = salary;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", positions=" + positions +
                ", salary=" + salary +
                ", store=" + store +
                '}' + "\n";
    }
}
