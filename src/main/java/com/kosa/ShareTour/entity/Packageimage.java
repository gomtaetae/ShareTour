package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="packageimages")
@Data
public class Packageimage implements Serializable {

    @Id
    @Column(name="packageimages_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int packageimagesid;

    @ManyToOne
    @JoinColumn(name="landmarks_id")
    private Landmark landmarkid;

    @ManyToOne
    @JoinColumn(name="accommodations_id")
    private Accommodation accommodationid;

    @ManyToOne
    @JoinColumn(name="restaurants_id")
    private Restaurant restaurantid;

    @Column(name="img")
    private String img;

}
