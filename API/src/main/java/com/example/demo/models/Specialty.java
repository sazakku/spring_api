package com.example.demo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "specialities")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public Specialty() {

    }

    public Specialty(String name) {
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
