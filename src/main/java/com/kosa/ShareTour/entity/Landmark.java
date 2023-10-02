package com.kosa.ShareTour.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name="landmarks")
@Getter
@Setter
@ToString
public class Landmark {

    @Id
    @Column(name="landmarks_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int landmarks_id;

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

    @Column(name="loc_x", length = 50, nullable = false)
    private String loc_x;

    @Column(name="loc_y", length = 50, nullable = false)
    private String loc_y;

    @Column(name="price")
    private float price;

}
