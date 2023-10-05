package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="packages")
@Data
public class Package implements Serializable {

    @Id
    @Column(name="packages_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int packagesid;

    @Column(name="title", length = 50, nullable = false)
    private String title;

    @Column(name="content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name="start_date", nullable = false)
    private LocalDate startdate;

    @Column(name="end_date", nullable = false)
    private LocalDate enddate;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdat;

    @Column(name="modified_at")
    private LocalDateTime modifiedat;

    @PrePersist
    protected void onCreate() {
        createdat = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedat = LocalDateTime.now();
    }

    @Column(name="img", nullable = false)
    private String img;

    @Column(name="totalprice", nullable = false)
    private float totalprice;

    @Column(name="duration", nullable = false)
    private int duration;

    @Column(name="expire")
    private LocalDateTime expire;

    @Column(name="in_stock")
    private int instock;

    @Column(name="stock_left")
    private int stockleft;

    @ManyToOne
    @JoinColumn(name="places_id")
    private Place placeid;

    @ManyToOne
    @JoinColumn(name="landmarks_id")
    private Landmark landmarkid;

    @ManyToOne
    @JoinColumn(name="accommodations_id")
    private Accommodation accommodationid;

    @ManyToOne
    @JoinColumn(name="restaurants_id")
    private Restaurant restaurantid;

}
