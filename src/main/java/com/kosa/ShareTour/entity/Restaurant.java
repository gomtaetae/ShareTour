package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="restaurants")
@Getter
@Setter
@ToString
public class Restaurant {

    @Id
    @Column(name="restaurants_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurants_id;

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
    private String loc_x;

    @Column(name="loc_y", length = 50, nullable = false)
    private String loc_y;

    @Column(name="price", nullable = false)
    private float price;

}