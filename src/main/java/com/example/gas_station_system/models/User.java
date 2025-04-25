package com.example.gas_station_system.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Lob
    private byte[] cnh;

    @Lob
    private byte[] worker;

    private LocalDate birth;

    // Construtor padrão
    public User() {}

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getCnh() {
        return cnh;
    }

    public void setCnh(byte[] cnh) {
        this.cnh = cnh;
    }

    public byte[] getWorker() {
        return worker;
    }

    public void setWorker(byte[] worker) {
        this.worker = worker;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
