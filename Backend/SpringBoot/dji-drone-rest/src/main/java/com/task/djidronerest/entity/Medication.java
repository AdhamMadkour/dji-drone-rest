package com.task.djidronerest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "{Medication.name.pattern}")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private Integer weight;
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9_]+$", message = "{Medication.code.pattern}")
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "drone_serial_number", nullable = false)
    @JsonBackReference
    private Drone drone;

    public Medication() {

    }

    public Medication(String name, String code, Integer weight, String image, Drone drone) {
        this.name = name;
        this.code = code;
        this.weight = weight;
        this.image = image;
        this.drone = drone;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", weight=" + weight +
                ", image='" + image + '\'' +
                ", drone=" + drone +
                '}';
    }
}
