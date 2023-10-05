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
    private int packages_id;

    @Column(name="title", length = 50, nullable = false)
    private String title;

    @Column(name="content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name="start_date", nullable = false)
    private LocalDate start_date;

    @Column(name="end_date", nullable = false)
    private LocalDate end_date;

    @Column(name="created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name="modified_at")
    private LocalDateTime modified_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modified_at = LocalDateTime.now();
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
    private int in_stock;

    @Column(name="stock_left")
    private int stock_left;

    @ManyToOne
    @JoinColumn(name="places_id")
    private Place place_id;

    @ManyToOne
    @JoinColumn(name="landmarks_id")
    private Landmark landmark_id;

    @ManyToOne
    @JoinColumn(name="accommodations_id")
    private Accommodation accommodation_id;

    @ManyToOne
    @JoinColumn(name="restaurants_id")
    private Restaurant restaurant_id;

}