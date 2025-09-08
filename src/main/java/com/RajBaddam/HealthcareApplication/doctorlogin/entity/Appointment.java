package com.RajBaddam.HealthcareApplication.doctorlogin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="symtomps")
    private String symtomps;

    @Column(name="number")
    private String number;

    public Appointment(Long id, String name, int age, String symtomps, String number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.symtomps = symtomps;
        this.number = number;
    }

    public Appointment() {
        super();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSymtomps() {
        return symtomps;
    }

    public void setSymtomps(String symtomps) {
        this.symtomps = symtomps;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
