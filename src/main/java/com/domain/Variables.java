package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="variables")
public class Variables {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String basic_salary;

    private String house_rent;

    private String medical;
    @Column(name="conve")

    private String con;
    @Column(name="festibal")

    private String festival;

    private String investment;
    private String category;
    private String zone;
    private String taxble_income;
    private String total_tax;
    private String m_tax;
    private String tax_year;

    public String getTax_year() {
        return tax_year;
    }

    public void setTax_year(String tax_year) {
        this.tax_year = tax_year;
    }

    public Long getId() {
        return id;
    }
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxble_income() {
        return taxble_income;
    }

    public void setTaxble_income(String taxble_income) {
        this.taxble_income = taxble_income;
    }

    public String getTotal_tax() {
        return total_tax;
    }

    public void setTotal_tax(String total_tax) {
        this.total_tax = total_tax;
    }

    public String getM_tax() {
        return m_tax;
    }

    public void setM_tax(String m_tax) {
        this.m_tax = m_tax;
    }

    public String getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(String basic_salary) {
        this.basic_salary = basic_salary;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }



    public String getHouse_rent() {
        return house_rent;
    }

    public void setHouse_rent(String house_rent) {
        this.house_rent = house_rent;
    }
}
