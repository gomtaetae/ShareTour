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
    private int auctions_id;

    @Column(name="finalprice")
    private float finalprice;

    @ManyToOne
    @JoinColumn(name="users_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name="accommodations_id")
    private Accommodation accommodation_id;

}
