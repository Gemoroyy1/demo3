package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    @Id
    @Basic
    @Column(name = "id")
    public int id;

    @Basic
    @Column(name = "name")
    public String name;

    @Basic
    @Column(name = "country")
    public String country;
}