package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="auctions")
@Data
public class Auction implements Serializable {

    @Id
    @Column(name="auctions_id")
    private Integer id;

    @Column(name="finalprice")
    private float finalPrice;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="accommodation_id")
    private Accommodation accommodation;

}