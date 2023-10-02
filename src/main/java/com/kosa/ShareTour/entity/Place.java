package com.kosa.ShareTour.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="places")
@Getter
@Setter
@ToString
public class Place {

    @Id
    @Column(name="places_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int places_id;

    @Column(name="countries", length = 50, nullable = false)
    private String countries;

    @Column(name="province", length = 50, nullable = false)
    private String province;

    @Column(name="city", length = 50, nullable = false)
    private String city;

    @Column(name="loc_x", length = 50, nullable = false)
    private String loc_x;

    @Column(name="loc_y", length = 50, nullable = false)
    private String loc_y;

    @Column(name="img")
    private String img;

}
