package com.task.djidronerest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "image")
    private String image;

    public Medication(String name, String code, String image) {
        this.name = name;
        this.code = code;
        this.image = image;
    }

    public Medication() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
