package com.kosa.ShareTour.entity;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="landmarks")
@Getter
@Setter
@ToString
public class Landmark {

    @Id
    @Column(name="landmarks_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="category", length = 45, nullable = false)
    private String category;

    @Column(name="address", length = 45)
    private String address;

    @Column(name="url", length = 45)
    private String url;

    @Column(name="phone", length = 45)
    private String phone;

    @Column(name="area", length = 45)
    private String area;

    @Column(name="parking")
    private String parking;

    @Column(name="loc_x", length = 50, nullable = false)
    private String locX;

    @Column(name="loc_y", length = 50, nullable = false)
    private String locY;

    @Column(name="price")
    private float price;

    @OneToMany(mappedBy = "landmark", cascade = CascadeType.REMOVE)
    private List<Package> packageList = new ArrayList<>();

}