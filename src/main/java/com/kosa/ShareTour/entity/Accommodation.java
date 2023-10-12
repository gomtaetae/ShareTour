package com.kosa.ShareTour.entity;

import com.kosa.ShareTour.constant.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accommodations")
@Getter
@Setter
@ToString
public class Accommodation {

    @Id
    @Column(name="accommodations_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", length = 45)
    private String address;

    @Column(name="url", length = 45)
    private String url;

    @Column(name="phone", length = 45)
    private String phone;

    @Column(name="area", length = 45)
    private String area;

    @Column(name="grade", length = 45)
    private String grade;

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


//    public static Accommodation createAccommodation(AccommodationFormDto accommodationFormDto) {
//        Accommodation accommo = new Accommodation();
//        accommo.setName(accommodationFormDto.getName());
//        accommo.setAddress(accommodationFormDto.getAddress());
//        accommo.setUrl(accommodationFormDto.getUrl());
//        accommo.setPhone(accommodationFormDto.getPhone());
//        accommo.setArea(accommodationFormDto.getArea());
//        accommo.setGrade(accommodationFormDto.getGrade());
//        accommo.setParking(accommodationFormDto.getParking());
//        accommo.setLocX(accommodationFormDto.getLocX());
//        accommo.setLocY(accommodationFormDto.getLocY());
//        accommo.setPrice(accommodationFormDto.getPrice());
//
//        return accommo;
//    }


}