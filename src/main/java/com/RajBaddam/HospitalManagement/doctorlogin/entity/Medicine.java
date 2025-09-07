package com.RajBaddam.HospitalManagement.doctorlogin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="drug_name")
    private String drugName;

    @Column(name="stock")
    private String stock;

    public Medicine(Long id, String drugName, String stock) {
        this.id = id;
        this.drugName = drugName;
        this.stock = stock;
    }

    public Medicine() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
