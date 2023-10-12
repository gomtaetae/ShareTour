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
    private Long id;

    @Column(name="title", length = 50, nullable = false)
    private String title;

    @Column(name="content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name="start_date", nullable = false)
    private LocalDate startDate;

    @Column(name="end_date", nullable = false)
    private LocalDate endDate;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at")
    private LocalDateTime modifiedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = LocalDateTime.now();
    }

    @Column(name="img", nullable = false)
    private String img;

    @Column(name="totalprice", nullable = false)
    private float totalPrice;

    @Column(name="duration", nullable = false)
    private int duration;

    @Column(name="expire")
    private LocalDateTime expire;

    @Column(name="in_stock")
    private int inStock;

    @Column(name="stock_left")
    private int stockLeft;

    @ManyToOne
    @JoinColumn(name="places_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name="landmarks_id")
    private Landmark landmark;

    @ManyToOne
    @JoinColumn(name="accommodations_id")
    private Accommodation accommodation;

    @ManyToOne
    @JoinColumn(name="restaurants_id")
    private Restaurant restaurant;

}