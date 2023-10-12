package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurants")
@Getter
@Setter
@ToString
public class Restaurant {

    @Id
    @Column(name="restaurants_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", length = 45)
    private String address;

    @Column(name="phone", length = 45)
    private String phone;

    @Column(name="area", length = 45)
    private String area;

    @Column(name="parking", length = 45)
    private String parking;

    @Column(name="loc_x", length = 50, nullable = false)
    private String locX;

    @Column(name="loc_y", length = 50, nullable = false)
    private String locY;

    @Column(name="price", nullable = false)
    private float price;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.REMOVE)
    private List<Package> packageList = new ArrayList<>();

}