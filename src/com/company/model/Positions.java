package com.company.model;

public class Positions {
    private long id;
    private String name;
    private boolean isActive;

    public Positions() {
    }

    public Positions(long id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
