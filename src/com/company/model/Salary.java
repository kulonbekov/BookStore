package com.company.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Salary {

    private Long id;
    private BigDecimal sum;
    private LocalDate startDate;
    private LocalDate endDate;

    public Salary() {
    }

    public Salary(long id, BigDecimal sum, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.sum = sum;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", sum=" + sum +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
