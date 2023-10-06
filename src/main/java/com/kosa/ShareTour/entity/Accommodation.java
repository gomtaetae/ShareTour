package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="accommodations")
@Getter
@Setter
@ToString
public class Accommodation {

    @Id
    @Column(name="accommodations_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int accommodationId;

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

}
